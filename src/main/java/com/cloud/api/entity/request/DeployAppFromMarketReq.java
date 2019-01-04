/**
 * 
 */
package com.cloud.api.entity.request;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.cloud.api.entity.ContainersDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.PortsDO;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author zhao_pengchen
 *
 */
public class DeployAppFromMarketReq {

	@NotEmpty(message = "appMarketId can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String appMarketId;
	
	@NotEmpty(message = "name can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
    @NotEmpty(message = "displayName can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String displayName;
	
	private String description;
    
    private List<AppFromMarketInfo> appFromMarketInfoList;
    
    private List<GetListParamElement> sort;
	
	private List<GetListParamElement> filter;
    
	public String getAppMarketId() {
		return appMarketId;
	}

	public void setAppMarketId(String appMarketId) {
		this.appMarketId = appMarketId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<AppFromMarketInfo> getAppFromMarketInfoList() {
		return appFromMarketInfoList;
	}

	public void setAppFromMarketInfoList(List<AppFromMarketInfo> appFromMarketInfoList) {
		this.appFromMarketInfoList = appFromMarketInfoList;
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

}
