package com.cloud.api.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.cloud.api.core.jwt.JwtAuthenticationFilter;
import com.cloud.api.core.jwt.JwtLoginFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	private static final String AUTHORIZATION_URL = "/oauth/token";

	private static final String HTTP_METHOD_POST = "POST";

	private static final String ROOT_PATH_URL = "/";

	private static final String HTML_PATH_URL = "/*.html";
	private static final String PNG_PATH_URL = "/**/*.png";
	private static final String SWAGGER_PATH_URL = "/swagger-resources/**/**";
	private static final String DOCS_PATH_URL = "/**/api-docs";
	private static final String WOFF_PATH_URL = "/**/**/**/*.woff";
	private static final String CSS_PATH_URL = "/**/**/*.css";
	private static final String JS_PATH_URL = "/**/**/*.js";

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers(HttpMethod.POST, AUTHORIZATION_URL)
				.permitAll()
				.antMatchers(HttpMethod.GET, ROOT_PATH_URL, HTML_PATH_URL, PNG_PATH_URL, SWAGGER_PATH_URL,
						DOCS_PATH_URL, WOFF_PATH_URL, CSS_PATH_URL, JS_PATH_URL)
				.permitAll().anyRequest().authenticated().and()
				// 添加一个过滤器 所有访问 /oauth/token 的请求交给 JWTLoginFilter 来处理 这个类处理所有的JWT相关内容
				.addFilterBefore(new JwtLoginFilter(AUTHORIZATION_URL, HTTP_METHOD_POST),
						UsernamePasswordAuthenticationFilter.class)

				// 添加一个过滤器验证其他请求的Token是否合法
				.addFilterBefore(new JwtAuthenticationFilter(authenticationManager()),
						UsernamePasswordAuthenticationFilter.class);
	}

}
