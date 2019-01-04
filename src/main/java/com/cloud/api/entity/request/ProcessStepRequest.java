/**
 * 
 */
package com.cloud.api.entity.request;

/**
 * @author zhao_pengchen
 *
 */
public class ProcessStepRequest {

	private String id;
	
	private String name;
	
	private String stepEnable;
	
	private String assignUser;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
