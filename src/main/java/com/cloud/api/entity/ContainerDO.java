package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

/**
* @author huang_kefei
* @date 2018年10月17日
* 类说明
*/
public class ContainerDO {
	
	private List<ContainersDO> containers;
	
	private String dnsPolicy;
	
	private String restartPolicy;
	
	private String schedulerName;
	
	private Map<String,String> securityContext;
	
//	private Integer terminationGracePeriodSeconds;
//	private String serviceAccountname;
//	
//	private String volumes;

	public List<ContainersDO> getContainers() {
		return containers;
	}

	public void setContainers(List<ContainersDO> containers) {
		this.containers = containers;
	}

	public String getDnsPolicy() {
		return dnsPolicy;
	}

	public void setDnsPolicy(String dnsPolicy) {
		this.dnsPolicy = dnsPolicy;
	}

	public String getRestartPolicy() {
		return restartPolicy;
	}

	public void setRestartPolicy(String restartPolicy) {
		this.restartPolicy = restartPolicy;
	}

	public String getSchedulerName() {
		return schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	
	public Map<String, String> getSecurityContext() {
		return securityContext;
	}

	public void setSecurityContext(Map<String, String> securityContext) {
		this.securityContext = securityContext;
	}

//	public int getTerminationGracePeriodSeconds() {
//		return terminationGracePeriodSeconds;
//	}
//
//	public void setTerminationGracePeriodSeconds(int terminationGracePeriodSeconds) {
//		this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
//	}
	
	
}
