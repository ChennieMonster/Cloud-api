package com.cloud.api.entity.request;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cloud.api.entity.AppInstanceDO;
import com.cloud.api.entity.GetListParamElement;

public class ApplicationRequest {
	
	@Valid
	private List<AppInstanceDO> instances;
	
	@NotEmpty(message = "{ApplicationRequest.applicationName.null}")
	@Size(max = 32, message = "{ApplicationRequest.applicationName.length}")
	private String applicationName;
	
	@NotEmpty(message = "{ApplicationRequest.applicationDisplayName.null}")
	@Size(max = 64, message = "{ApplicationRequest.applicationDisplayName.length}")
	private String applicationDisplayName;
	
	@Size(max = 256, message = "{ApplicationRequest.applicationDescription.length}")
	private String applicationDescription;
	
	private String uuid;
	
	private List<String> ids;
	
	private List<GetListParamElement> sort;
	
	private List<GetListParamElement> filter;
	
	private Integer currentPage;
	
	private Integer pageSize;
	
	private List<Map<String, String>> parameters;
	
	private int isRegistry;
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

	public List<Map<String, String>> getParameters() {
		return parameters;
	}

	public void setParameters(List<Map<String, String>> parameters) {
		this.parameters = parameters;
	}

	public List<AppInstanceDO> getInstances() {
		return instances;
	}

	public void setInstances(List<AppInstanceDO> instances) {
		this.instances = instances;
	}

	public List<GetListParamElement> getSort() {
		return sort;
	}

	public void setSort(List<GetListParamElement> sort) {
		this.sort = sort;
	}

	public List<GetListParamElement> getFilter() {
		return filter;
	}

	public void setFilter(List<GetListParamElement> filter) {
		this.filter = filter;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDisplayName() {
		return applicationDisplayName;
	}

	public void setApplicationDisplayName(String applicationDisplayName) {
		this.applicationDisplayName = applicationDisplayName;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public int getIsRegistry() {
		return isRegistry;
	}

	public void setIsRegistry(int isRegistry) {
		this.isRegistry = isRegistry;
	}

}
