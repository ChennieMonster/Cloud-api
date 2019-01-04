package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年11月5日 类说明
 */
public class CapabilitiesDO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, List<String>> capabilities;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Boolean privileged;
	
	public Map<String, List<String>> getCapabilities() {
		return capabilities;
	}

	public void setCapabilities(Map<String, List<String>> capabilities) {
		this.capabilities = capabilities;
	}

	public Boolean getPrivileged() {
		return privileged;
	}

	public void setPrivileged(Boolean privileged) {
		this.privileged = privileged;
	}
	
	
}
