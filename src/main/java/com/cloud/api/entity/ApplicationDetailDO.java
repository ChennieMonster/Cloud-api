/**
 * 
 */
package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author zhao_pengchen
 *
 */
public class ApplicationDetailDO {

	@NotEmpty(message = "instances can't be null")
	private List<AppInstanceDO> instances;
	
	@NotEmpty(message = "applicationName can't be null")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String applicationName;
	
	@NotEmpty(message = "applicationDisplayName can't be null")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String applicationDisplayName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String applicationDescription;
	
	private List<Map<String, String>> parameters;

	public List<AppInstanceDO> getInstances() {
		return instances;
	}

	public void setInstances(List<AppInstanceDO> instances) {
		this.instances = instances;
	}

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	public String getApplicationDisplayName() {
		return applicationDisplayName;
	}

	public void setApplicationDisplayName(String applicationDisplayName) {
		this.applicationDisplayName = applicationDisplayName;
	}

	public String getApplicationDescription() {
		return applicationDescription;
	}

	public void setApplicationDescription(String applicationDescription) {
		this.applicationDescription = applicationDescription;
	}

	public List<Map<String, String>> getParameters() {
		return parameters;
	}

	public void setParameters(List<Map<String, String>> parameters) {
		this.parameters = parameters;
	}
	
}
