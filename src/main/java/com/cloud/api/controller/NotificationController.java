
/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.entity.response.NotificationResponse;
import com.cloud.api.service.NotificationService;

/**
 * @author shi_lin
 *
 */
@RestController
@RequestMapping("/notifications")
public class NotificationController {

	@Resource
	private NotificationService notificationService;
	

	@GetMapping
	public Result<List<NotificationResponse>> getNotificationsAll() {
		List<NotificationResponse> list = notificationService.queryNotificationsAll();
		return ResultGenerator.genListOkResult(list.size(), list.size(), list);
	}
	
	@GetMapping("/{id}")
	public Result<NotificationResponse> getNotificationsDetail(@PathVariable String id) {
		NotificationResponse response = notificationService.queryNotificationsDetail(id);
		return ResultGenerator.genGetOkResult(response);
	}
}
