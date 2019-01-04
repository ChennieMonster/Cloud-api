package com.cloud.api.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.response.ProjectResourceResponse;
import com.cloud.api.entity.response.RegionResourceResponse;
import com.cloud.api.service.ProjectService;
import com.cloud.api.service.ResourcesService;

/**
 * @author shi_lin
 */
@RestController
@RequestMapping("/resources")
public class ResourceController {
	
	@Resource
	private ProjectService projectService;
	
	@Resource
	private ResourcesService resourcesService;
	
	@GetMapping()
	public Result<RegionResourceResponse> getRegionResource(@RequestBody GuiRequestBody<?> requestBody){
		RegionResourceResponse regionResourceResponse = resourcesService.queryResourceByRegion(requestBody.getRegion());
		return ResultGenerator.genGetOkResult(regionResourceResponse);
	}
	
	@GetMapping("projects")
	public Result<ProjectResourceResponse> getProjectResource(@RequestBody GuiRequestBody<?> requestBody){
		ProjectDTO projectDTO = projectService.queryProjectByRegionIdAndProjectName(requestBody.getRegion(),requestBody.getProject());
		ProjectResourceResponse response = resourcesService.queryResourceByProject(requestBody.getRegion(), projectDTO.getUuid());
		return ResultGenerator.genGetOkResult(response);
	}
	
}
