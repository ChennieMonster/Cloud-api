package com.cloud.api.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import com.cloud.api.core.jwt.JwtLoginFilter;
import com.cloud.api.core.response.ResultGenerator;

public class MessageUtils {

	private static MessageSource messageSource = (MessageSource) SpringContextUtils.getBean(MessageSource.class);

	private final static Logger logger = LoggerFactory.getLogger(JwtLoginFilter.class);

	public static final String ERR_TOKEN_FORMAT = "ERR_AUTH_001";

	public static final String ERR_BAD_CREDENTIALS = "ERR_AUTH_002";

	public static final String ERR_AUTH_FAILED = "ERR_AUTH_003";

	public static final String ERR_BAD_REQUEST = "ERR_AUTH_004";

	public static final String ERR_ARGS_NOT_VALID = "ERR_AUTH_005";

	public static final String ERR_FORBIDDEN = "ERR_AUTH_006";

	public static final String ERR_INTERNAL = "ERR_AUTH_007";

	/**
	 * 国际化 无动态参数
	 * 
	 * @param id
	 * @param param
	 * @return message string
	 */
	public static String getMessage(String id) {
		String message = "";
		try {
			Locale locale = LocaleContextHolder.getLocale();
			message = messageSource.getMessage(id, null, locale);
		} catch (Exception e) {
			logger.error("parse message error! ", e);
		}

		return message;
	}

	/**
	 * 国际化 动态参数，param中替换message中的参数
	 * 
	 * @param id
	 * @param param
	 * @return message string
	 */
	public static String getMessage(String id, Object[] param) {
		String message = "";
		try {
			Locale locale = LocaleContextHolder.getLocale();
			message = messageSource.getMessage(id, param, locale);
		} catch (Exception e) {
			logger.error("parse message error! ", e);
		}

		return message;
	}

	/**
	 * 返回response格式message
	 * 
	 * @param id
	 * @param param
	 * @return message string
	 */
	public static String getResponseMessage(String id) {
		String message = getMessage(id);
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put("message", message);
		return JsonUtils.objectToJsonPretty(messageMap);
	}

	/**
	 * 返回response格式message
	 * 
	 * @param id
	 * @param param
	 * @return message string
	 */
	public static String getResponseMessage(String id, Object[] param) {
		String message = getMessage(id, param);
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put("message", message);
		return JsonUtils.objectToJsonPretty(messageMap);
	}

	/**
	 * 返回response格式message
	 * 
	 * @param id
	 * @param param
	 * @return message string
	 */
	public static String formatMessage(String message) {
		Map<String, String> messageMap = new HashMap<String, String>();
		messageMap.put("message", message);
		return JsonUtils.objectToJsonPretty(messageMap);
	}

	/**
	 * 返回response格式message
	 * 
	 * @param id
	 * @param param
	 * @return message string
	 */
	public static void setResponse(HttpServletResponse response, int statusCode, String message, Object[]... param) {
		response.setContentType(ClientConstants.CONTENT_TYPE_JSON);
		response.setCharacterEncoding(ClientConstants.ENCODING_UTF8);
		response.setStatus(statusCode);

		try {
			if (null != param) {
				response.getWriter()
						.write(JsonUtils.objectToJsonPretty(ResultGenerator.genFailedResult(statusCode, message)));
			} else {
				response.getWriter()
						.write(JsonUtils.objectToJsonPretty(ResultGenerator.genFailedResult(statusCode, message)));
			}
		} catch (IOException e) {
			logger.error(e.getMessage());
		}
	}
}
