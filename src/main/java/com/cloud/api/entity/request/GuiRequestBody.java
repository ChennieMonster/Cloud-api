/**
 * 
 */
package com.cloud.api.entity.request;

import javax.validation.Valid;

/**
 * @author zhao_pengchen
 *
 */
public class GuiRequestBody<T> {

	private String project;
	
	private String region;
	
	@Valid
	private T data ;

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
