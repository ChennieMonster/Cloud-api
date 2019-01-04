package com.cloud.api.entity.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
* @author huang_kefei
* @date 2018年11月21日
* 类说明
* route一览的返回值
*/
public class RouteResponseData {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String uuid;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String instanceName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String applicationName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date createdTime;

	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	
}
