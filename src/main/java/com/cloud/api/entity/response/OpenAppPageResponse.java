/**
 * 
 */
package com.cloud.api.entity.response;

import java.util.List;
import java.util.Map;

/**
 * @author zhao_pengchen
 *
 */
public class OpenAppPageResponse {

	private String deploymentName;
	
	private double cpu;
	
	private double memory;
	
	private Integer replicas;
	
	private String host;
	
	private List<Map<String, Object>> env;
	
	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public double getCpu() {
		return cpu;
	}

	public void setCpu(double cpu) {
		this.cpu = cpu;
	}

	public double getMemory() {
		return memory;
	}

	public void setMemory(double memory) {
		this.memory = memory;
	}

	public Integer getReplicas() {
		return replicas;
	}

	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}

	public List<Map<String, Object>> getEnv() {
		return env;
	}

	public void setEnv(List<Map<String, Object>> env) {
		this.env = env;
	}

}
