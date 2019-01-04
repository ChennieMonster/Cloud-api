package com.cloud.api.util.resolver;

import javax.annotation.Resource;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.cloud.api.entity.TokenDO;
import com.cloud.api.service.AuthOpenShiftService;
import com.cloud.api.service.TemplateService;
import com.cloud.api.util.SpringContextUtils;
import com.cloud.api.util.annotation.TokenParam;

public class TokenArgumentResolver implements HandlerMethodArgumentResolver {

	@Resource
	private AuthOpenShiftService authService = (AuthOpenShiftService) SpringContextUtils
			.getBean(AuthOpenShiftService.class);

	@Resource
	private TemplateService templateService;

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(TokenParam.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		String userName = webRequest.getUserPrincipal().getName();
		TokenDO token = authService.getOpenShiftToken(userName);
		return token;
	}
}
