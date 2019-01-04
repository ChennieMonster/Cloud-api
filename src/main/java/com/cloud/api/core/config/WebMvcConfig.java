package com.cloud.api.core.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.cloud.api.util.resolver.TokenArgumentResolver;

/**
 * Spring MVC 配置
 *
 * @author zhang.feng
 * @date 2018/09/27
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

	/**
	 * 视图控制器
	 */
	@Override
	public void addViewControllers(final ViewControllerRegistry registry) {
		// solved swagger2
		registry.addRedirectViewController("/v2/api-docs", "/v2/api-docs?group=restful-api");
		registry.addRedirectViewController("/swagger-resources/configuration/ui",
				"/swagger-resources/configuration/ui");
		registry.addRedirectViewController("/swagger-resources/configuration/security",
				"/swagger-resources/configuration/security");
		registry.addRedirectViewController("/swagger-resources", "/swagger-resources");
	}

	/**
	 * 资源控制器
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		// solved swagger2
		registry.addResourceHandler("/swagger-ui.html**")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	/**
	 * 参数解析器
	 */
	@Override
	protected void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {

		// 注册TokenArgumentResolver的参数分解器
		argumentResolvers.add(new TokenArgumentResolver());
	}
	
	public ResourceBundleMessageSource getMessageSource() throws Exception {
		ResourceBundleMessageSource rbms = new ResourceBundleMessageSource();
		rbms.setDefaultEncoding("UTF-8");
		rbms.setBasenames("i18n/messages");
		rbms.setCacheSeconds(10);
		return rbms;
	}
	
	@Bean
	@Override
	public Validator getValidator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		try {
			validator.setValidationMessageSource(getMessageSource());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validator;
	}
}
