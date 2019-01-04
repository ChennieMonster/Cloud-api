package com.cloud.api.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huang_kefei
 * @date 2018年9月28日 类说明
 */
@ApiModel(value = "set实体")
public class ReplicasetDTO {
    /**
     * 主键
     */
	@ApiModelProperty(value = "uuid")
	@NotEmpty(message = "{replicaset.uuid.null}")
	@Size(max = 128, message = "{replicaset.uuid.length}")
    private String uuid;

    /**
     * 名称
     */
	@ApiModelProperty(value = "name")
	@NotEmpty(message = "{replicaset.name.null}")
	@Size(max = 32, message = "{replicaset.name.length}")
    private String name;

    /**
     * DeploymentID
     */
	@ApiModelProperty(value = "deploymentId")
	@NotEmpty(message = "{replicaset.deploymentId.null}")
	@Size(max = 128, message = "{replicaset.deploymentId.length}")
    private String deploymentId;

    /**
     * 创建时间
     */
	@ApiModelProperty(value = "createdTime")
	@NotEmpty(message = "{replicaset.CreatedTime.null}")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    /**
     * 状态
     */
	@ApiModelProperty(value = "status")
    private String status;

    /**
     * ReplicationController/ReplicaSet
     */
	@ApiModelProperty(value = "kind")
    private String kind;

    /**
     * 
     */
	@ApiModelProperty(value = "progressDeadlineSeconds")
    private Integer progressDeadlineSeconds;

    /**
     * 
     */
	@ApiModelProperty(value = "replicas")
    private Integer replicas;

    /**
     * 
     */
	@ApiModelProperty(value = "revisionHistoryLimit")
    private Integer revisionHistoryLimit;

    /**
     * 
     */
	@ApiModelProperty(value = "selector")
    private String selector;

    /**
     * 
     */
	@ApiModelProperty(value = "strategy")
    private String strategy;
	
	@ApiModelProperty(value = "template")
	private String template;
	
	
	 /**
     * 
     */
    private String metadata;

    /**
     * 
     */
    private String apiVersion;

    /**
     * 
     */
    private String spec;


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

	public String getDeploymentId() {
		return deploymentId;
	}

	public void setDeploymentId(String deploymentId) {
		this.deploymentId = deploymentId;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public Integer getProgressDeadlineSeconds() {
		return progressDeadlineSeconds;
	}

	public void setProgressDeadlineSeconds(Integer progressDeadlineSeconds) {
		this.progressDeadlineSeconds = progressDeadlineSeconds;
	}

	public Integer getReplicas() {
		return replicas;
	}

	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}

	public Integer getRevisionHistoryLimit() {
		return revisionHistoryLimit;
	}

	public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
		this.revisionHistoryLimit = revisionHistoryLimit;
	}

	public String getSelector() {
		return selector;
	}

	public void setSelector(String selector) {
		this.selector = selector;
	}

	public String getStrategy() {
		return strategy;
	}

	public void setStrategy(String strategy) {
		this.strategy = strategy;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}


 
}
