/**
 * 
 */
package com.cloud.api.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.api.service.ProjectService;
import com.cloud.api.service.UserService;

/**
 * 获取token
 * @author zhao_pengchen
 *
 */
@Validated
@Controller
@RequestMapping("/getToken")
public class GetTokenController {

	@Autowired
    private UserService userService;
	
	@Autowired
    private ProjectService projectService;
	
	@GetMapping("")
	public String getToken(@RequestBody final String username, @RequestBody final String password, Model model) throws UnsupportedEncodingException {

		final Base64 base64 = new Base64();
		final String text = username + password;
		final byte[] textByte = text.getBytes("UTF-8");
		//编码
		final String token = base64.encodeToString(textByte);
		model.addAttribute("token", token);
		Map<String, Object> paramMap = new HashMap<String, Object>();
		
		paramMap.put("userName", username);
		Map<String, Object> userMap = userService.queryUserInfo(paramMap);
		model.addAttribute("role", userMap.get("role_id"));
		model.addAttribute("language", userMap.get("language"));
		
		// TODO
		return "/url";
	}
	
}
