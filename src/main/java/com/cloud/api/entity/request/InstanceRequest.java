package com.cloud.api.entity.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.GetListParamElement;

/**
 * 
 * @author zhao_pengchen
 *
 */
public class InstanceRequest {

	private List<GetListParamElement> sort;
	
	private List<GetListParamElement> filter;
	
	private Integer currentPage;
	
	private Integer pageSize;
	
	@NotEmpty(message = "{AppInstanceDO.instanceName.null}")
	@Size(max = 32, message = "{AppInstanceDO.instanceName.length}")
	private String instanceName;
	
	@NotEmpty(message = "{AppInstanceDO.instanceDisplayName.null}")
	@Size(max = 64, message = "{AppInstanceDO.instanceDisplayName.length}")
	private String instanceDisplayName;
	
	@Size(max = 256, message = "{AppInstanceDO.instanceDescription.length}")
	private String instanceDescription;
	
	private List<AppInstanceDetailDO> objects;

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

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getInstanceDisplayName() {
		return instanceDisplayName;
	}

	public void setInstanceDisplayName(String instanceDisplayName) {
		this.instanceDisplayName = instanceDisplayName;
	}

	public String getInstanceDescription() {
		return instanceDescription;
	}

	public void setInstanceDescription(String instanceDescription) {
		this.instanceDescription = instanceDescription;
	}

	public List<AppInstanceDetailDO> getObjects() {
		return objects;
	}

	public void setObjects(List<AppInstanceDetailDO> objects) {
		this.objects = objects;
	}
	
}
