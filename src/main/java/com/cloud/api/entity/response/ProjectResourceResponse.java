package com.cloud.api.entity.response;

import java.util.List;
import java.util.Map;

import com.cloud.api.dto.ResourcesDTO;

public class ProjectResourceResponse {
	
	private ResourcesDTO projectResources;
	
	private List<Map<String,Object>> projectAppStatusList;
	
	private List<Map<String,Object>> appResources;
	
	public ProjectResourceResponse() {
		super();
	}
	
	public ProjectResourceResponse(ResourcesDTO projectResources, List<Map<String, Object>> projectAppStatusList,
			List<Map<String, Object>> appResources) {
		super();
		this.projectResources = projectResources;
		this.projectAppStatusList = projectAppStatusList;
		this.appResources = appResources;
	}

	public ResourcesDTO getProjectResources() {
		return projectResources;
	}

	public void setProjectResources(ResourcesDTO projectResources) {
		this.projectResources = projectResources;
	}

	public List<Map<String, Object>> getProjectAppStatusList() {
		return projectAppStatusList;
	}

	public void setProjectAppStatusList(List<Map<String, Object>> projectAppStatusList) {
		this.projectAppStatusList = projectAppStatusList;
	}

	public List<Map<String, Object>> getAppResources() {
		return appResources;
	}

	public void setAppResources(List<Map<String, Object>> appResources) {
		this.appResources = appResources;
	}
}
