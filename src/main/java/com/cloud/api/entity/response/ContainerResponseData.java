package com.cloud.api.entity.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
* @author huang_kefei
* @date 2018年12月19日
* 类说明
* container一览
*/
public class ContainerResponseData {
	
	private String conId;

	private String name;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date createdTime;
	
	private String  status;

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
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
