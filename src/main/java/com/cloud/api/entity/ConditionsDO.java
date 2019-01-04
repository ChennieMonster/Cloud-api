package com.cloud.api.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年10月25日 类说明
 */
public class ConditionsDO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String availableReplicas;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String status;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastUpdateTime;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastTransitionTime;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String reason;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastProbeTime;

	public String getLastProbeTime() {
		return lastProbeTime;
	}

	public void setLastProbeTime(String lastProbeTime) {
		this.lastProbeTime = lastProbeTime;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAvailableReplicas() {
		return availableReplicas;
	}

	public void setAvailableReplicas(String availableReplicas) {
		this.availableReplicas = availableReplicas;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getLastUpdateTime() {
		return lastUpdateTime;
	}

	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastTransitionTime() {
		return lastTransitionTime;
	}

	public void setLastTransitionTime(String lastTransitionTime) {
		this.lastTransitionTime = lastTransitionTime;
	}

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

}
