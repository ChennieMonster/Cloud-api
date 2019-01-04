package com.cloud.api.entity.request;

import java.util.List;

import com.cloud.api.entity.GetListParamElement;

public class RequestData {
	
	private List<GetListParamElement> filter;
	
	private List<String> ids;
	
	public List<GetListParamElement> getFilter() {
		return filter;
	}

	public void setFilter(List<GetListParamElement> filter) {
		this.filter = filter;
	}

	public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}
	
}
