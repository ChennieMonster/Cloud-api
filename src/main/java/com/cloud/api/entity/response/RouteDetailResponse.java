package com.cloud.api.entity.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年11月28日 类说明
 */
public class RouteDetailResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String host;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String serviceName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer serviceWeight;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String labels;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}


	public Integer getServiceWeight() {
		return serviceWeight;
	}

	public void setServiceWeight(Integer serviceWeight) {
		this.serviceWeight = serviceWeight;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

}
