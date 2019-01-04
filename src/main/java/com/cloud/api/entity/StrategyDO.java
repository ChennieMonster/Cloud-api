package com.cloud.api.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

public class StrategyDO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, Integer> rollingUpdate;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;

	public Map<String, Integer> getRollingUpdate() {
		return rollingUpdate;
	}

	public void setRollingUpdate(Map<String, Integer> rollingUpdate) {
		this.rollingUpdate = rollingUpdate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
