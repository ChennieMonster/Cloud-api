package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MonitorAlarmDTO {
    /**
     * 
     */
	@ApiModelProperty(hidden=true)
    private String uuid;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String description;

    /**
     * host/application
     */
    private String type;

    /**
     * 
     */
    @ApiModelProperty(hidden=true)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    /**
     * 
     */
    @ApiModelProperty(hidden=true)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date updateTime;
    
    private Integer applyTotal;
    
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	public Integer getApplyTotal() {
		return applyTotal;
	}

	public void setApplyTotal(Integer applyTotal) {
		this.applyTotal = applyTotal;
	}
}