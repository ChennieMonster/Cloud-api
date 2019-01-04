package com.cloud.api.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class PodDTO {
    /**
     * 主键
     */
	@ApiModelProperty(value = "uuid")
	@NotEmpty(message = "{pod.uuid.null}")
	@Size(max = 128, message = "{pod.uuid.length}")
    private String uuid;

    /**
     * 
     */
	@ApiModelProperty(value = "setId")
	@NotEmpty(message = "{pod.setId.null}")
	@Size(max = 128, message = "{pod.setId.length}")
    private String setId;

    /**
     * 
     */
	@ApiModelProperty(value = "metaData")
    private String metaData;

    /**
     * 
     */
	@ApiModelProperty(value = "spec")
    private String spec;

    /**
     * 
     */
	@ApiModelProperty(value = "dnsPolicy")
    private String dnsPolicy;

    /**
     * 
     */
	@ApiModelProperty(value = "restartPolicy")
    private String restartPolicy;

    /**
     * 
     */
	@ApiModelProperty(value = "schedulerName")
    private String schedulerName;

    /**
     * 
     */
	@ApiModelProperty(value = "securityContext")
    private String securityContext;

    /**
     * 
     */
	@ApiModelProperty(value = "terminationGracePeriodSeconds")
    private Integer terminationGracePeriodSeconds;

    /**
     * 
     */
	@ApiModelProperty(value = "name")
    private String name;

    /**
     * 
     */
	@ApiModelProperty(value = "ready")
    private String ready;

    /**
     * 
     */
	@ApiModelProperty(value = "status")
    private String status;

    /**
     * 
     */
	@ApiModelProperty(value = "restarts")
    private String restarts;

    /**
     * 
     */
	@ApiModelProperty(value = "age")
    private String age;

    /**
     * 
     */
	@ApiModelProperty(value = "rs")
    private String rs;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getSetId() {
		return setId;
	}

	public void setSetId(String setId) {
		this.setId = setId;
	}

	public String getMetaData() {
		return metaData;
	}

	public void setMetaData(String metaData) {
		this.metaData = metaData;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDnsPolicy() {
		return dnsPolicy;
	}

	public void setDnsPolicy(String dnsPolicy) {
		this.dnsPolicy = dnsPolicy;
	}

	public String getRestartPolicy() {
		return restartPolicy;
	}

	public void setRestartPolicy(String restartPolicy) {
		this.restartPolicy = restartPolicy;
	}

	public String getSchedulerName() {
		return schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public String getSecurityContext() {
		return securityContext;
	}

	public void setSecurityContext(String securityContext) {
		this.securityContext = securityContext;
	}

	public Integer getTerminationGracePeriodSeconds() {
		return terminationGracePeriodSeconds;
	}

	public void setTerminationGracePeriodSeconds(Integer terminationGracePeriodSeconds) {
		this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReady() {
		return ready;
	}

	public void setReady(String ready) {
		this.ready = ready;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRestarts() {
		return restarts;
	}

	public void setRestarts(String restarts) {
		this.restarts = restarts;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRs() {
		return rs;
	}

	public void setRs(String rs) {
		this.rs = rs;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

   
}