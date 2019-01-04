package com.cloud.api.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
* @author huang_kefei
* @date 2018年10月25日
* 类说明
*/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StatusDO {
	
	private Integer observedGeneration;

	private Integer replicas;

	private Integer updatedReplicas;

	private Integer readyReplicas;

	private Integer availableReplicas;
	
	private List<ConditionsDO> conditions;

	private String hostIP;

	private String phase;

	private String podIP;

	private String qosClass;

	private Date startTime;
	
	private List<ContainerStatuseDO> containerStatuses;
	
	private Map<String,String> selector;
	
	private String targetSelector;
	
	private String reason;
	
	private String message;

	
	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Map<String, String> getSelector() {
		return selector;
	}

	public void setSelector(Map<String, String> selector) {
		this.selector = selector;
	}

	public String getTargetSelector() {
		return targetSelector;
	}

	public void setTargetSelector(String targetSelector) {
		this.targetSelector = targetSelector;
	}

	public String getHostIP() {
		return hostIP;
	}

	public void setHostIP(String hostIP) {
		this.hostIP = hostIP;
	}

	public String getPhase() {
		return phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getPodIP() {
		return podIP;
	}

	public void setPodIP(String podIP) {
		this.podIP = podIP;
	}

	public String getQosClass() {
		return qosClass;
	}

	public void setQosClass(String qosClass) {
		this.qosClass = qosClass;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public List<ContainerStatuseDO> getContainerStatuses() {
		return containerStatuses;
	}

	public void setContainerStatuses(List<ContainerStatuseDO> containerStatuses) {
		this.containerStatuses = containerStatuses;
	}

	public Integer getObservedGeneration() {
		return observedGeneration;
	}

	public void setObservedGeneration(Integer observedGeneration) {
		this.observedGeneration = observedGeneration;
	}

	public Integer getReplicas() {
		return replicas;
	}

	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}

	public Integer getUpdatedReplicas() {
		return updatedReplicas;
	}

	public void setUpdatedReplicas(Integer updatedReplicas) {
		this.updatedReplicas = updatedReplicas;
	}

	public Integer getReadyReplicas() {
		return readyReplicas;
	}

	public void setReadyReplicas(Integer readyReplicas) {
		this.readyReplicas = readyReplicas;
	}

	public Integer getAvailableReplicas() {
		return availableReplicas;
	}

	public void setAvailableReplicas(Integer availableReplicas) {
		this.availableReplicas = availableReplicas;
	}

	public List<ConditionsDO> getConditions() {
		return conditions;
	}

	public void setConditions(List<ConditionsDO> conditions) {
		this.conditions = conditions;
	}
	

}
