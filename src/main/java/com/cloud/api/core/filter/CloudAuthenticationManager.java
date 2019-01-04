package com.cloud.api.core.filter;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.cloud.api.dto.UserDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.service.AuthOpenShiftService;
import com.cloud.api.service.UserService;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.MessageUtils;
import com.cloud.api.util.SpringContextUtils;
import com.cloud.api.util.UrlUtils;

public class CloudAuthenticationManager implements AuthenticationManager {
	static final List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
	
	@Resource
	private UserService userService = (UserService) SpringContextUtils.getBean(UserService.class);

	@Resource
	private AuthOpenShiftService authService = (AuthOpenShiftService) SpringContextUtils
			.getBean(AuthOpenShiftService.class);

	// 构建一个角色列表
	static {
		AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));
	}

	// 验证方法
	public Authentication authenticate(Authentication auth) throws AuthenticationException {
		//从openshift校验
		//administrator
		if("administrator".equals(auth.getPrincipal().toString())) {
			UserDTO user = userService.findByUserName((String) auth.getPrincipal());
			//用户密码都一致
			if (user.getPassword() != null && user.getPassword().equals(auth.getCredentials())) {
				return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
			}
		}
		//other user
//		if(authService.authUser(auth.getPrincipal().toString(), auth.getCredentials().toString())) {
			UserDTO user = userService.findByUserName((String) auth.getPrincipal());
			//用户不存在
			if (user.getUserName() == null) {
				//insert
				userService.insertUser(auth.getPrincipal().toString(), auth.getCredentials().toString());
				return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
			}
			//用户密码都一致
			if (user.getPassword() != null && user.getPassword().equals(auth.getCredentials())) {
				return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
			}
			//密码不一致，更新密码
			if(user.getPassword() != null && !user.getPassword().equals(auth.getCredentials())) {
				//update pwd
				userService.updateUserByName(auth.getPrincipal().toString(), auth.getCredentials().toString());
				return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
			}
//		}
//		// 自定義驗證條件
//		UserDTO user = userService.findByUserName((String) auth.getPrincipal());
//		if (user.getUserName() == null
//				&& authService.authUser(auth.getPrincipal().toString(), auth.getCredentials().toString())) {
//			return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
//		}
//		if (user.getPassword() != null && user.getPassword().equals(auth.getCredentials())) {
//			return new UsernamePasswordAuthenticationToken(auth.getName(), auth.getCredentials(), AUTHORITIES);
//		}
		// 没有通过认证则抛出密码错误异常
		throw new BadCredentialsException(MessageUtils.getMessage(MessageUtils.ERR_BAD_CREDENTIALS));
	}
	
	
}
