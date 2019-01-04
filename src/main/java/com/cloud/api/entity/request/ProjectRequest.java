/**
 * 
 */
package com.cloud.api.entity.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author zhao_pengchen
 *
 */
public class ProjectRequest {

	@NotEmpty(message = "{ProjectRequest.name.null}")
	@Size(max = 32, message = "{ProjectRequest.name.length}")
	private String name;

	@NotEmpty(message = "{ProjectRequest.displayName.null}")
	@Size(max = 64, message = "{ProjectRequest.displayName.length}")
	private String displayName;

	@Size(max = 256, message = "{ProjectRequest.description.length}")
	private String description;

	private BigDecimal cpuQuota;

	private BigDecimal memoryQuota;

	private int podsQuota;

	private String taskId;

	private String processId;

	private String reason;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPodsQuota() {
		return podsQuota;
	}

	public void setPodsQuota(int podsQuota) {
		this.podsQuota = podsQuota;
	}

	public BigDecimal getCpuQuota() {
		return cpuQuota;
	}

	public void setCpuQuota(BigDecimal cpuQuota) {
		this.cpuQuota = cpuQuota;
	}

	public BigDecimal getMemoryQuota() {
		return memoryQuota;
	}

	public void setMemoryQuota(BigDecimal memoryQuota) {
		this.memoryQuota = memoryQuota;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getProcessId() {
		return processId;
	}

	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

}
