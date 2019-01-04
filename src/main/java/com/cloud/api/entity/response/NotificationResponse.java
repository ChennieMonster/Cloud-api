package com.cloud.api.entity.response;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NotificationResponse {
	
	private String notificationName;
	
	private String id;
	
	private String monitorName;
	
	private String monitorRule;
	
	private String monitorObj;
	
	private String value;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdTime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonitorName() {
		return monitorName;
	}

	public void setMonitorName(String monitorName) {
		this.monitorName = monitorName;
	}

	public String getMonitorRule() {
		return monitorRule;
	}

	public void setMonitorRule(String monitorRule) {
		this.monitorRule = monitorRule;
	}

	public String getMonitorObj() {
		return monitorObj;
	}

	public void setMonitorObj(String monitorObj) {
		this.monitorObj = monitorObj;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNotificationName() {
		return notificationName;
	}

	public void setNotificationName(String notificationName) {
		this.notificationName = notificationName;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
}
