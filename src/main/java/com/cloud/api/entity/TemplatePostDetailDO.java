/**
 * 
 */
package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.cloud.api.model.ModelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 发送到openshift的templateJson
 * @author zhao_pengchen
 *
 */
public class TemplatePostDetailDO implements ModelEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6179574428582232404L;

	@NotEmpty(message = "{templatePostDetailDO.apiVersion.is.not.null}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String apiVersion;
	
	@NotEmpty(message = "{templatePostDetailDO.kind.is.not.null}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String kind;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, String> labels;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<AppInstanceDetailDO> objects;
	
	@Valid
	@NotEmpty(message = "{templatePostDetailDO.metaData.is.not.null}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MetaDataDO metadata;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> parameters;

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<AppInstanceDetailDO> getObjects() {
		return objects;
	}

	public void setObjects(List<AppInstanceDetailDO> objects) {
		this.objects = objects;
	}

	public MetaDataDO getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaDataDO metadata) {
		this.metadata = metadata;
	}

	public List<Map<String, String>> getParameters() {
		return parameters;
	}

	public void setParameters(List<Map<String, String>> parameters) {
		this.parameters = parameters;
	}
	
	
	
}
