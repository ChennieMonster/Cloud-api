package com.cloud.api.core.jwt;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.cloud.api.core.filter.CloudAuthenticationManager;
import com.cloud.api.dto.UserDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.mapper.TokenMapper;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.UserService;
import com.cloud.api.util.AuthConstants;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.JwtUtils;
import com.cloud.api.util.MessageUtils;
import com.cloud.api.util.SpringContextUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtLoginFilter extends AbstractAuthenticationProcessingFilter {

	private static final String GUI_TOKEN_TYPE = "cloudapi";

	private static final String RESPONSE_KEY_TOKEN = "token";
	private static final String RESPONSE_KEY_USERNAME = "username";
	private static final String RESPONSE_KEY_USERID = "userId";

	private static final String RESPONSE_KEY_EXPIRESAT = "expiresAt";
	private static final String RESPONSE_KEY_LANGUAGE = "language";
	private static final String RESPONSE_KEY_PROJECT = "project";
	private static final String RESPONSE_KEY_REGION = "region";
	private static final String RESPONSE_KEY_SESSION = "session";


	private AuthenticationManager authenticationManager;

	private final static Logger logger = LoggerFactory.getLogger(JwtLoginFilter.class);

	@Resource
	private ProjectService projectService = (ProjectService) SpringContextUtils.getBean(ProjectService.class);

	@Resource
	private TokenMapper tokenMapper = (TokenMapper) SpringContextUtils.getBean(TokenMapper.class);

	@Resource
	private UserService userService = (UserService) SpringContextUtils.getBean(UserService.class);

	public JwtLoginFilter(String url, String method) {
		super(new AntPathRequestMatcher(url, method));
		this.authenticationManager = new CloudAuthenticationManager();
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		UserDTO user;
		response.setContentType(ClientConstants.CONTENT_UTF8_TYPE_JSON);
		response.setCharacterEncoding(ClientConstants.ENCODING_UTF8);
		try {
			user = new ObjectMapper().readValue(request.getInputStream(), UserDTO.class);
			return authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword(), new ArrayList<>()));

		} catch (BadCredentialsException e) {
			logger.error(e.getMessage());
			MessageUtils.setResponse(response, HttpStatus.SC_UNAUTHORIZED,
					MessageUtils.getMessage(MessageUtils.ERR_BAD_CREDENTIALS));
			return null;
		} catch (AuthenticationException e) {
			logger.error(e.getMessage());
			MessageUtils.setResponse(response, ClientConstants.UN_AUTHHORIZED_RESPONSE_CODE,
					MessageUtils.getMessage(MessageUtils.ERR_AUTH_FAILED));
			return null;
		} catch (IOException e) {
			logger.error(e.getMessage());
			MessageUtils.setResponse(response, ClientConstants.BAD_REQUEST_RESPONSE_CODE,
					MessageUtils.getMessage(MessageUtils.ERR_BAD_REQUEST));
			return null;
		}
	}

	/**
	 * create token
	 */
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		Date expirestime = new Date(System.currentTimeMillis() + 60 * 60 * 1000);
		String token = Jwts.builder().setSubject((String) authResult.getPrincipal()).setExpiration(expirestime)
				.signWith(SignatureAlgorithm.HS512, AuthConstants.JWT_SIGN_KEY).compact();

		TokenDO tokenGui = new TokenDO();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
		tokenGui.setUuid(IdGen.uuid());
		tokenGui.setTokenId(token);
		tokenGui.setExpiresTime(expirestime);
		tokenGui.setUserName((String) authResult.getPrincipal());
		tokenGui.setCreateTime(new Date());
		tokenGui.setType(GUI_TOKEN_TYPE);
		tokenMapper.insertToken(tokenGui);

		// String projectName = projectService.selectProjectByUserName((String)
		// authResult.getPrincipal()).getProject_name();
		
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userName", (String) authResult.getPrincipal());
		Map<String, Object> userMap = userService.queryUserInfo(paramMap);
		Map<String, Object> bodyMap = new HashMap<String, Object>();
		Map<String, Object> sessionMap = new HashMap<String, Object>();

		bodyMap.put(RESPONSE_KEY_TOKEN, JwtUtils.getTokenHeader(token));
		bodyMap.put(RESPONSE_KEY_USERNAME, (String) authResult.getPrincipal());
		bodyMap.put(RESPONSE_KEY_USERID, userMap.get("uuid").toString());
		bodyMap.put(RESPONSE_KEY_EXPIRESAT, sdf.format(expirestime).toString());
		sessionMap.put(RESPONSE_KEY_LANGUAGE, userMap.get("language").toString());
		sessionMap.put(RESPONSE_KEY_PROJECT, userMap.get("project"));
		sessionMap.put(RESPONSE_KEY_REGION, userMap.get("region"));
		bodyMap.put(RESPONSE_KEY_SESSION, sessionMap);
		response.getWriter().write(JsonUtils.objectToJson(bodyMap).toString());
	}

	/**
	 * Authentication fail
	 */
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		MessageUtils.setResponse(response, ClientConstants.UN_AUTHHORIZED_RESPONSE_CODE,
				MessageUtils.getResponseMessage(MessageUtils.ERR_AUTH_FAILED));
	}
}
