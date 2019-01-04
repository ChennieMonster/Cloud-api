/**
 * 
 */
package com.cloud.api.entity.request;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import com.cloud.api.entity.ToDO;

/**
 * @author zhao_pengchen
 *
 */
public class AppFromMarketInfo {
	
	@NotEmpty(message = "{deployment.name.null}")
	private String deploymentName;
	
	@NotEmpty(message = "{DeployAppFromMarketReq.cpu.null}")
	private double cpu;
	
	@NotEmpty(message = "{DeployAppFromMarketReq.memory.null}")
	private double memory;
	
    @NotEmpty(message = "{DeployAppFromMarketReq.replicas.null}")
	private Integer replicas;
	
    @NotEmpty(message = "{DeployAppFromMarketReq.host.null}")
    private String host;
    
    private List<Map<String, Object>> env;
    
	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
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

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public List<Map<String, Object>> getEnv() {
		return env;
	}

	public void setEnv(List<Map<String, Object>> env) {
		this.env = env;
	}

}
