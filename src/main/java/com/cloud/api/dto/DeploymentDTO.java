package com.cloud.api.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author huang_kefei
 * @date 2018年9月28日 类说明
 */
@ApiModel(value = "deployment")
public class DeploymentDTO {
    /**
     * 主键
     */
	@ApiModelProperty(value = "uuid")
	@NotEmpty(message = "{deployment.uuid.null}")
	@Size(max = 128, message = "{deployment.uuid.length}")
    private String uuid;
	
	

    /**
     * name
     */
	@ApiModelProperty(value = "name")
	@Size(max = 128, message = "{deployment.name.length}")
	@Pattern(regexp="[a-z0-9]([-a-z0-9]*[a-z0-9])?(\\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*", message="{name.pattern}")
    private String name;
	

    /**
     * 实例ID
     */
	@ApiModelProperty(value = "instanceId")
	@NotEmpty(message = "{deployment.instanceId.null}")
	@Size(max = 128, message = "{deployment.instanceId.length}")
    private String instanceId;

    /**
     * 创建时间
     */
	@ApiModelProperty(value = "createTime")
	@NotEmpty(message = "{deployment.createdTime.null}")
	@JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    /**
     * 版本
     */
	@ApiModelProperty(value = "lastVersion")
    private String lastVersion;

    /**
     * 状态
     */
	@ApiModelProperty(value = "status")
    private String status;

    /**
     * 
     */
	@ApiModelProperty(value = "kind")
    private String kind;

    /**
     * 
     */
	@ApiModelProperty(value = "metadata")
    private String metaData;

    /**
     * 
     */
	@ApiModelProperty(value = "spec")
    private String spec;

    /**
     * 
     */
	@ApiModelProperty(value = "apiVersion")
    private String apiVersion;
	
	@ApiModelProperty(value = "project")
	private String project;

	
	
    public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
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

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
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

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
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

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

//    public String getDisplay_name() {
//        return display_name;
//    }
//
//    public void setDisplay_name(String display_name) {
//        this.display_name = display_name;
//    }

}