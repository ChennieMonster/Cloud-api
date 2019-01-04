package com.cloud.api.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModel;

/**
 * @author zhao_pengchen
 *
 */
@ApiModel(value = "template")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApplicationDTO implements Serializable {

	private static final long serialVersionUID = -7961304519828056156L;

	private String uuid;
	
    @NotEmpty(message = "name can't be null")
	private String name;
	
    @NotEmpty(message = "displayName can't be null")
	private String displayName;
	
	private String status;
	
	private String description;
	
	private String deptLevel;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdTime;
	
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date updatedTime;
	
	private String parameters;
	
	private int isRegistry;
	
	private String project;
	
	private List<String> objectList;
	
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeptLevel() {
		return deptLevel;
	}

	public void setDeptLevel(String deptLevel) {
		this.deptLevel = deptLevel;
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

	public String getParameters() {
		return parameters;
	}

	public void setParameters(String parameters) {
		this.parameters = parameters;
	}

	public int getIsRegistry() {
		return isRegistry;
	}

	public void setIsRegistry(int isRegistry) {
		this.isRegistry = isRegistry;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public List<String> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<String> objectList) {
		this.objectList = objectList;
	}
}
