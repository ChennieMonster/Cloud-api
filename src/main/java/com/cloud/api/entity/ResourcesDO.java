package com.cloud.api.entity;

import java.util.Map;

/**
* @author huang_kefei
* @date 2018年11月14日
* 类说明
*/
public class ResourcesDO {
	private Map<String,String> limits;
	
	private Map<String,String> requests;

	public Map<String, String> getLimits() {
		return limits;
	}

	public void setLimits(Map<String, String> limits) {
		this.limits = limits;
	}

	public Map<String, String> getRequests() {
		return requests;
	}

	public void setRequests(Map<String, String> requests) {
		this.requests = requests;
	}
	
	
}
