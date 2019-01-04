package com.cloud.api.entity.request;

import java.util.List;
import java.util.Map;

import com.cloud.api.entity.GetListParamElement;

public class UserProjectRoleRequest {
	private String uuid;
	private String userId;
	private String roleId;
	private String projectId;
	private String regionId;
	private List<GetListParamElement> sort;
	private List<GetListParamElement> filter;
	private Integer currentPage;
	private Integer pageSize;
	private List<String> ids;
	private List<Map<String,Object>> insertList;
	
	public List<Map<String, Object>> getInsertList() {
		return insertList;
	}
	public void setInsertList(List<Map<String, Object>> insertList) {
		this.insertList = insertList;
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
	public List<String> getIds() {
		return ids;
	}
	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	public String getProjectId() {
		return projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	
	
}
