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
@ApiModel(value = "instance")
public class AppInstanceDTO implements Serializable {

	private static final long serialVersionUID = 6211468207436650922L;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String uuid;
	
    @NotEmpty(message = "name can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
    @NotEmpty(message = "displayName can't be null")
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String displayName;
	
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String description;
	
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String lastVersion;

    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer trigger;

    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String templateId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String applicationId;

    @JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date updatedTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
	private String objects;
    
    @JsonInclude(JsonInclude.Include.NON_NULL)
	private int podsCount;

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

	public String getLastVersion() {
		return lastVersion;
	}

	public void setLastVersion(String lastVersion) {
		this.lastVersion = lastVersion;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getTrigger() {
		return trigger;
	}

	public void setTrigger(Integer trigger) {
		this.trigger = trigger;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
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

	public String getObjects() {
		return objects;
	}

	public void setObjects(String objects) {
		this.objects = objects;
	}

	public int getPodsCount() {
		return podsCount;
	}

	public void setPodsCount(int podsCount) {
		this.podsCount = podsCount;
	}


}
