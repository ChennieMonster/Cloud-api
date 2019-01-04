package com.cloud.api.entity.request;

import java.util.List;

import com.cloud.api.entity.GetListParamElement;

/**
 * @author huang_kefei
 * @date 2018年11月21日 类说明
 */
public class BaseRequest {
	private List<GetListParamElement> sort;

	private List<GetListParamElement> filter;

	private Integer currentPage;

	private Integer pageSize;

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

}
