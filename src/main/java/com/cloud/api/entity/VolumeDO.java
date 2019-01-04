package com.cloud.api.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年11月5日 类说明
 */
public class VolumeDO {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, String> secret;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Object emptyDir;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getSecret() {
		return secret;
	}

	public void setSecret(Map<String, String> secret) {
		this.secret = secret;
	}

	public Object getEmptyDir() {
		return emptyDir;
	}

	public void setEmptyDir(Object emptyDir) {
		this.emptyDir = emptyDir;
	}

	
}
