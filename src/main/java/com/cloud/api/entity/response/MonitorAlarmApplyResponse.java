package com.cloud.api.entity.response;

public class MonitorAlarmApplyResponse {
	
	private String monitorAlarmId;
	
	private String name;
	
	private String displayName;
	
	private String description;
	
	private String monitorObjId;
	
	public MonitorAlarmApplyResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MonitorAlarmApplyResponse(String monitorAlarmId, String name, String displayName, String description,
			String monitorObjId) {
		super();
		this.monitorAlarmId = monitorAlarmId;
		this.name = name;
		this.displayName = displayName;
		this.description = description;
		this.monitorObjId = monitorObjId;
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

	public String getMonitorObjId() {
		return monitorObjId;
	}

	public void setMonitorObjId(String monitorObjId) {
		this.monitorObjId = monitorObjId;
	}

	public String getMonitorAlarmId() {
		return monitorAlarmId;
	}

	public void setMonitorAlarmId(String monitorAlarmId) {
		this.monitorAlarmId = monitorAlarmId;
	}
	
}
