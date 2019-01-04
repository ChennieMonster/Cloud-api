/**
 * 
 */
package com.cloud.api.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author zhao_pengchen
 *
 */
@ApiModel(value = "template实体")
public class TemplateDTO implements Serializable{

	private static final long serialVersionUID = 3492362281183888280L;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String uuid;

	@JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "name can't be null")
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "displayName can't be null")
	private String displayName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;

	@JsonInclude(JsonInclude.Include.NON_NULL)
    @NotEmpty(message = "type can't be null")
	private String type;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer instanceCount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdTime;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date updatedTime;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String templateContent;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String apiVersion;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String metadata;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String objects;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String kind;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String message;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String labels;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String parameters;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String project;
	
	private Integer isMarket;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getInstanceCount() {
		return instanceCount;
	}

	public void setInstanceCount(Integer instanceCount) {
		this.instanceCount = instanceCount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}

	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	public String getTemplateContent() {
		return templateContent;
	}

	public void setTemplateContent(String templateContent) {
		this.templateContent = templateContent;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getObjects() {
		return objects;
	}

	public void setObjects(String objects) {
		this.objects = objects;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public Integer getIsMarket() {
		return isMarket;
	}

	public void setIsMarket(Integer isMarket) {
		this.isMarket = isMarket;
	}

}
