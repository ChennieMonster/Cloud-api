package com.cloud.api.entity.request;

import java.util.List;

import com.cloud.api.dto.MonitorAlarmDTO;
import com.cloud.api.dto.MonitorRuleAlarmDTO;

public class MonitorRuleRequestData {
	
	private MonitorAlarmDTO monitorAlarm;
	
	private List<MonitorRuleAlarmDTO> rules;

	public MonitorAlarmDTO getMonitorAlarm() {
		return monitorAlarm;
	}

	public void setMonitorAlarm(MonitorAlarmDTO monitorAlarm) {
		this.monitorAlarm = monitorAlarm;
	}

	public List<MonitorRuleAlarmDTO> getRules() {
		return rules;
	}

	public void setRules(List<MonitorRuleAlarmDTO> rules) {
		this.rules = rules;
	}

	
}
