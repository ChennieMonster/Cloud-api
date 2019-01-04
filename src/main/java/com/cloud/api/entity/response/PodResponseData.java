package com.cloud.api.entity.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年11月6日 类说明
 */

public class PodResponseData {
	private String uuid;
	
	private String name;
	
	private String node;
	
	private String ip;
	
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date createdTime;
	
	private String status;

	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getNode() {
		return node;
	}

	public void setNode(String node) {
		this.node = node;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	public Date getCreatedTime() {
		return createdTime;
	}

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
