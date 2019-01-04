
/**
 * 
 */
package com.cloud.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.MonitorRuleRequestData;
import com.cloud.api.service.MonitorService;

/**
 * @author shi_lin
 *
 */
@RestController
@RequestMapping("/monitorRules")
public class MonitorRuleController {

	@Resource
	private MonitorService monitorService;
	
	@PostMapping
	public Result<?> addMonitorRule (@RequestBody GuiRequestBody<MonitorRuleRequestData> requestBody){
		monitorService.addMonitorAlarm(requestBody.getData());
		return ResultGenerator.genOkResult();
	}
}
