package com.cloud.api.entity;

import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonInclude;

public class MetaDataDO {

	@NotEmpty(message = "{metaData.name.is.not.null}")
	@Pattern(regexp="[a-z0-9]([-a-z0-9]*[a-z0-9])?(\\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*", message="{name.pattern}")
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String namespace;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, String> annotations;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String creationTimestamp;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, String> labels;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String resourceVersion;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String selfLink;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String uid;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer generation;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String generateName;
	

	public String getGenerateName() {
		return generateName;
	}

	public void setGenerateName(String generateName) {
		this.generateName = generateName;
	}

	public String getCreationTimestamp() {
		return creationTimestamp;
	}

	public void setCreationTimestamp(String creationTimestamp) {
		this.creationTimestamp = creationTimestamp;
	}

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	public String getResourceVersion() {
		return resourceVersion;
	}

	public void setResourceVersion(String resourceVersion) {
		this.resourceVersion = resourceVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public Map<String, String> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Map<String, String> annotations) {
		this.annotations = annotations;
	}

	public String getSelfLink() {
		return selfLink;
	}

	public void setSelfLink(String selfLink) {
		this.selfLink = selfLink;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getGeneration() {
		return generation;
	}

	public void setGeneration(Integer generation) {
		this.generation = generation;
	}

}
