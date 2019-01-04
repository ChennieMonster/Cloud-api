package com.cloud.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.util.JsonUtils;

@RestController
@RequestMapping("/oauth/token")
public class AuthController {

	@GetMapping("")
	public String authentication(HttpServletRequest request) {
		return JsonUtils.objectToJsonPretty(ResultGenerator.genOkResult());
	}
}
