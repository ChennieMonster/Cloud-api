package com.cloud.api.service.impl;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Service;

import com.cloud.api.core.jwt.JwtAuthenticationFilter;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.UserDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.mapper.TokenMapper;
import com.cloud.api.service.AuthOpenShiftService;
import com.cloud.api.service.UserService;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.UrlUtils;

@Service
public class AuthOpenShiftServiceImpl extends BaseService implements AuthOpenShiftService {

	private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	private static final String RESPONSE_HEADER_LOCATION = "Location";
	private static final String RESPONSE_HEADER_ACCESS_TOKEN = "access_token";
	private static final String RESPONSE_HEADER_EXPIRES_IN = "expires_in";
	private static final String AUTHORIZATION_HEADER_TYPE_K = "response_type";
	private static final String AUTHORIZATION_HEADER_CLIENT_ID_K = "client_id";
	private static final String AUTHORIZATION_HEADER_TYPE_V = "token";
	private static final String AUTHORIZATION_HEADER_CLIENT_ID_V = "openshift-challenging-client";
	private static final String OS_TOKEN_TYPE = "openshift";

	@Resource
	private TokenMapper tokenMapper;

	@Resource
	private UserService userService;

	@Override
	public TokenDO getOpenShiftToken(String userName) throws Exception {
		TokenDO token = new TokenDO();
		Map<String, String> queryTokenParam = new HashMap<String, String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		queryTokenParam.put("userName", userName);
		queryTokenParam.put("type", OS_TOKEN_TYPE);
		queryTokenParam.put("expiresTime", sdf.format(new Date()).toString());
		ArrayList<TokenDO> tokenList = tokenMapper.queryToken(queryTokenParam);
		if (tokenList.size() > 0)
			return tokenList.get(0);

		UserDTO user = userService.findByUserName(userName);
		token = createTokenByUser(userName, user.getPassword());
		tokenMapper.insertToken(token);
		return token;
	}

	public boolean authUser(String userName, String passwd) {
		String userData = GenUserAuthData(userName, passwd);
		try {
			CloseableHttpResponse response = AuthorizeUser(userData);
			if (null == response) {
				return false;
			}
		} catch (BadCredentialsException e) {
			logger.error("openshift auth failed detail:" + e.getMessage());
			return false;
		}
//		Map<String, Object> paramMap = new HashMap<String, Object>();
//		paramMap.put("userName", userName);
//		paramMap.put("userId", IdGen.uuid());
//		paramMap.put("passward", passwd);
//		paramMap.put("creater", userName);
//		userService.addUserInfo(paramMap);
		return true;
	}

	private TokenDO createTokenByUser(String userName, String passwd) {
		TokenDO token = new TokenDO();
		CloseableHttpResponse response = null;
		String userData = GenUserAuthData(userName, passwd);
		response = AuthorizeUser(userData);
		if (null == response) {
			logger.info("response is null");
			return token;
		}

		String location = response.getLastHeader(RESPONSE_HEADER_LOCATION).getValue();
		String accessToken = UrlUtils.getParamByUrl(location, RESPONSE_HEADER_ACCESS_TOKEN);
		String expiresIn = UrlUtils.getParamByUrl(location, RESPONSE_HEADER_EXPIRES_IN);

		// insert token
		token.setTokenId(accessToken);
		long expiresTime = System.currentTimeMillis() + Long.parseLong(expiresIn) * 1000;
		token.setUuid(IdGen.uuid());
		token.setExpiresTime(new Date(expiresTime));
		token.setUserName(userName);
		token.setCreateTime(new Date());
		token.setType(OS_TOKEN_TYPE);
		return token;
	}

	private CloseableHttpResponse AuthorizeUser(String userData) {
		CloseableHttpResponse response = null;
		Map<String, String> reqHeaders = new HashMap<String, String>();
		reqHeaders.put(ClientConstants.HEADER_AUTHORIZATION, userData.toString());

		Map<String, String> reqParams = new HashMap<String, String>();
		reqParams.put(AUTHORIZATION_HEADER_TYPE_K, AUTHORIZATION_HEADER_TYPE_V);
		reqParams.put(AUTHORIZATION_HEADER_CLIENT_ID_K, AUTHORIZATION_HEADER_CLIENT_ID_V);
		response = post(AuthOpenShiftService.class, uri("/oauth/authorize"), null).headers(reqHeaders).params(reqParams)
				.executeWithResponseWithRegion();
		return response;
	}

	private String GenUserAuthData(String userName, String passwd) {
		StringBuffer userData = new StringBuffer("Basic ");
		StringBuilder userAndPass = new StringBuilder();
		userAndPass.append(userName).append(":").append(passwd);
		byte[] b;
		try {
			b = userAndPass.toString().getBytes("utf-8");
			userData = userData.append(Base64.getEncoder().encodeToString(b));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return userData.toString();
	}
}
