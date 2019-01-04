package com.cloud.api.entity;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

public class AppInstanceDO {
	
	@NotEmpty(message = "{AppInstanceDO.instanceName.null}")
	@Size(max = 32, message = "{AppInstanceDO.instanceName.length}")
	private String instanceName;
	
	@NotEmpty(message = "{AppInstanceDO.instanceDisplayName.null}")
	@Size(max = 64, message = "{AppInstanceDO.instanceDisplayName.length}")
	private String instanceDisplayName;
	
	@Size(max = 256, message = "{AppInstanceDO.instanceDescription.length}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String instanceDescription;
	
	private List<AppInstanceDetailDO> objects;

	public String getInstanceName() {
		return instanceName;
	}

	public void setInstanceName(String instanceName) {
		this.instanceName = instanceName;
	}

	public String getInstanceDisplayName() {
		return instanceDisplayName;
	}

	public void setInstanceDisplayName(String instanceDisplayName) {
		this.instanceDisplayName = instanceDisplayName;
	}

	public String getInstanceDescription() {
		return instanceDescription;
	}

	public void setInstanceDescription(String instanceDescription) {
		this.instanceDescription = instanceDescription;
	}

	public List<AppInstanceDetailDO> getObjects() {
		return objects;
	}

	public void setObjects(List<AppInstanceDetailDO> objects) {
		this.objects = objects;
	}

}
