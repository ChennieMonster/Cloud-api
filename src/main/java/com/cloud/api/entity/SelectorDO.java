package com.cloud.api.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

public class SelectorDO {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String app;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, String> matchLabels;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getMatchLabels() {
		return matchLabels;
	}

	public void setMatchLabels(Map<String, String> matchLabels) {
		this.matchLabels = matchLabels;
	}

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}
	
}
