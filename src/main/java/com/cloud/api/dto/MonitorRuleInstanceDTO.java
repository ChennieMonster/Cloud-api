package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;

public class MonitorRuleInstanceDTO {
    /**
     * 
     */
	@ApiModelProperty(hidden=true)
    private String uuid;

    /**
     * 
     */
    private String monitorObjAlarmId;

    /**
     * 
     */
    private String item;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Long period;

    /**
     * 
     */
    private Float threshold;

    /**
     * 
     */
    private String unit;

    /**
     * 
     */
    private String action;

    /**
     * 
     */
    private String notifications;

    /**
     * 
     */
    @ApiModelProperty(hidden=true)
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMonitorObjAlarmId() {
        return monitorObjAlarmId;
    }

    public void setMonitorObjAlarmId(String monitorObjAlarmId) {
        this.monitorObjAlarmId = monitorObjAlarmId;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getPeriod() {
        return period;
    }

    public void setPeriod(Long period) {
        this.period = period;
    }

    public Float getThreshold() {
        return threshold;
    }

    public void setThreshold(Float threshold) {
        this.threshold = threshold;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}