package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;


public class TemplateDetailDO {
	
	private List<AppInstanceDO> instances;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String templateName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String templateDisplayName;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String templateDescription;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	
	private List<Map<String, String>> parameters;
	
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getTemplateDisplayName() {
		return templateDisplayName;
	}

	public void setTemplateDisplayName(String templateDisplayName) {
		this.templateDisplayName = templateDisplayName;
	}

	public String getTemplateDescription() {
		return templateDescription;
	}

	public void setTemplateDescription(String templateDescription) {
		this.templateDescription = templateDescription;
	}

	public List<Map<String, String>> getParameters() {
		return parameters;
	}

	public void setParameters(List<Map<String, String>> parameters) {
		this.parameters = parameters;
	}

	public List<AppInstanceDO> getInstances() {
		return instances;
	}

	public void setInstances(List<AppInstanceDO> instances) {
		this.instances = instances;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
