/**
 * 
 */
package com.cloud.api.entity.request;

/**
 * @author zhao_pengchen
 *
 */
public class ApprovalRequest {

	private String reason;
	
	private String status;
	
	private String taskId;
	
	private String applyUser;

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getTaskId() {
		return taskId;
	}

	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}

	public String getApplyUser() {
		return applyUser;
	}

	public void setApplyUser(String applyUser) {
		this.applyUser = applyUser;
	}
	
}
