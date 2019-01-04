package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.entity.EventDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.service.EventService;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/pod/{podId}/events")
public class EventController {
	
	@Resource
	private EventService eventService;
	
	@GetMapping
	public Result<List<EventDO>> getContainerDetail(@ApiIgnore @TokenParam TokenDO token,@PathVariable String podId) {
		List<EventDO> eventList = eventService.getPodEvents(podId, token);
		return ResultGenerator.genListOkResult(eventList.size(), eventList.size(), eventList);
	}
	
}
