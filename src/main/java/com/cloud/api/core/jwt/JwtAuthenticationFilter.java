package com.cloud.api.core.jwt;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.filter.BodyReaderHttpServletRequestWrapper;
import com.cloud.api.core.http.HttpHelper;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.util.AuthConstants;
import com.cloud.api.util.ClientConstants;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.JwtUtils;
import com.cloud.api.util.MessageUtils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;

public class JwtAuthenticationFilter extends BasicAuthenticationFilter {

	private final static Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

	public JwtAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader(AuthConstants.AUTHORIZATION_HEADER);
		response.setContentType(ClientConstants.CONTENT_UTF8_TYPE_JSON);
		response.setCharacterEncoding(ClientConstants.ENCODING_UTF8);
		if (header == null) {
			chain.doFilter(request, response);
			return;
		}
		if (null != header && !header.startsWith(JwtUtils.getAuthorizationHeaderPrefix())) {
			logger.error(MessageUtils.getResponseMessage(MessageUtils.ERR_TOKEN_FORMAT) + "missing Bearer");
			MessageUtils.setResponse(response, HttpStatus.SC_FORBIDDEN,
					MessageUtils.getResponseMessage(MessageUtils.ERR_TOKEN_FORMAT));
			return;
		}
		 	

		try {
			UsernamePasswordAuthenticationToken authenticationToken = getUsernamePasswordAuthenticationToken(header);
			SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			request.setAttribute(MDCConstants.USER_NAME, authenticationToken.getPrincipal().toString());
			ServletRequest requestWrapper = new BodyReaderHttpServletRequestWrapper(request);
			//region
	        String json = HttpHelper.getBodyString(requestWrapper);
	        String region = "";
	        try {
				 region=JsonUtils.jsonToObject(json, GuiRequestBody.class).getRegion();
				 logger.warn("region:"+region);
			}catch (Exception e) {
				// TODO: handle exception
				logger.warn("get region error");
			}
	        requestWrapper.setAttribute(MDCConstants.REGION_ID, region);
			chain.doFilter(requestWrapper, response);
		} catch (ExpiredJwtException e) {
			logger.error("Expired JWT token.Detail:" + e.getMessage());
			MessageUtils.setResponse(response, HttpStatus.SC_FORBIDDEN, e.getMessage().split("[.]")[0]);
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token.Detail:" + e.getMessage());
			MessageUtils.setResponse(response, HttpStatus.SC_FORBIDDEN, e.getMessage());
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature.Detail:" + e.getMessage());
			MessageUtils.setResponse(response, HttpStatus.SC_FORBIDDEN, e.getMessage());
		} catch (Exception e) {
			logger.error("Exception.Detail:" + e.getMessage());
			MessageUtils.setResponse(response, HttpStatus.SC_FORBIDDEN, e.getMessage());
		}
	}

	private UsernamePasswordAuthenticationToken getUsernamePasswordAuthenticationToken(String token) {
		String user = Jwts.parser().setSigningKey(AuthConstants.JWT_SIGN_KEY)
				.parseClaimsJws(token.replace(JwtUtils.getAuthorizationHeaderPrefix(), AuthConstants.EMPTY_STRING))
				.getBody().getSubject();

		if (null != user) {
			return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
		}

		return null;
	}
}
