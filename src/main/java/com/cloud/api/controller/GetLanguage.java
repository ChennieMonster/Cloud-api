/**
 * 
 */
package com.cloud.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cloud.api.dto.UserDTO;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.service.UserService;

/**
 * 获取用户使用语言
 * @author zhao_pengchen
 *
 */
@Validated
@Controller
@RequestMapping("/getLanguage")
public class GetLanguage {

	@Autowired
    private UserService userService;
	
	@GetMapping("")
	public String getToken(@RequestBody final String username, Model model) {

		UserDTO user = userService.findByUserName(username);
		model.addAttribute("language", user.getLanguage());
		
		// TODO
		return "/url";
	}
	
}
