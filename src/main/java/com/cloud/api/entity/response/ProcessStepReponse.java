/**
 * 
 */
package com.cloud.api.entity.response;

/**
 * @author zhao_pengchen
 *
 */
public class ProcessStepReponse {

	private String id;
	private String name;
	private String sourceFlowId;
	private String targetFlowId;
	private String flowId;
	private String stepEnable;
	private String assignUser;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFlowId() {
		return flowId;
	}
	public void setFlowId(String flowId) {
		this.flowId = flowId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSourceFlowId() {
		return sourceFlowId;
	}
	public void setSourceFlowId(String sourceFlowId) {
		this.sourceFlowId = sourceFlowId;
	}
	public String getTargetFlowId() {
		return targetFlowId;
	}
	public void setTargetFlowId(String targetFlowId) {
		this.targetFlowId = targetFlowId;
	}
	public String getStepEnable() {
		return stepEnable;
	}
	public void setStepEnable(String stepEnable) {
		this.stepEnable = stepEnable;
	}
	public String getAssignUser() {
		return assignUser;
	}
	public void setAssignUser(String assignUser) {
		this.assignUser = assignUser;
	}
	
}
