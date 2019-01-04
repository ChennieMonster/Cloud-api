package com.cloud.api.entity.response;

import java.util.List;
import java.util.Map;

import com.cloud.api.dto.ResourcesDTO;

public class RegionResourceResponse {
	
	private ResourcesDTO hostResources;
	
	private List<ResourcesDTO> projectResources;
	
	private List<Map<String,Object>> projectApps;
	
	private Map<String,Object> appInfo;
	
	public RegionResourceResponse() {
		super();
	}
	
	public RegionResourceResponse(ResourcesDTO hostResources, List<ResourcesDTO> projectResources,
			List<Map<String, Object>> projectApps, Map<String,Object> appInfo) {
		super();
		this.hostResources = hostResources;
		this.projectResources = projectResources;
		this.projectApps = projectApps;
		this.appInfo = appInfo;
	}

	public ResourcesDTO getHostResources() {
		return hostResources;
	}

	public void setHostResources(ResourcesDTO hostResources) {
		this.hostResources = hostResources;
	}

	public List<ResourcesDTO> getProjectResources() {
		return projectResources;
	}

	public void setProjectResources(List<ResourcesDTO> projectResources) {
		this.projectResources = projectResources;
	}

	public List<Map<String, Object>> getProjectApps() {
		return projectApps;
	}

	public void setProjectApps(List<Map<String, Object>> projectApps) {
		this.projectApps = projectApps;
	}

	public Map<String, Object> getAppInfo() {
		return appInfo;
	}

	public void setAppInfo(Map<String, Object> appInfo) {
		this.appInfo = appInfo;
	}

}
