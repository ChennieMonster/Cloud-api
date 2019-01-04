package com.cloud.api.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author shi_lin
 */
@ApiModel(value = "Route实体")
public class RouteDTO {

	private String uuid;
	
	@NotEmpty(message = "name can't be null")
	private String name;
	
	@ApiModelProperty(value = "实例ID")
	@NotEmpty(message = "instanceId can't be null")
	private String instanceId;

	private String dnsName;

	@ApiModelProperty(value = "")
	private String tlsTermination;

	@ApiModelProperty(value = "")
	private String service;

	@ApiModelProperty(value = "")
	private String weight;

	@ApiModelProperty(value = "")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date createdTime;

	@ApiModelProperty(value = "Kind")
	@NotEmpty(message = "can't be null")
	private String kind;

	@ApiModelProperty(value = "Metadata")
	@NotEmpty(message = "can't be null")
	private String metadata;

	@ApiModelProperty(value = "Spec")
	@NotEmpty(message = "can't be null")
	private String spec;

	@ApiModelProperty(value = "ApiVersion")
	@NotEmpty(message = "can't be null")
	private String apiVersion;

	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
	private Date updatedTime;
	
	private String status;
	
	private String project;
	 
	 
	
	public String getProject() {
		return project;
	}


	public void setProject(String project) {
		this.project = project;
	}


	public String getStatus() {
		return status;
	}

	
	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdatedTime() {
		return updatedTime;
	}
	
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getDnsName() {
		return dnsName;
	}

	public void setDnsName(String dnsName) {
		this.dnsName = dnsName;
	}

	public String getTlsTermination() {
		return tlsTermination;
	}

	public void setTlsTermination(String tlsTermination) {
		this.tlsTermination = tlsTermination;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getMetadata() {
		return metadata;
	}

	public void setMetadata(String metadata) {
		this.metadata = metadata;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}