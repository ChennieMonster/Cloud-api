package com.cloud.api.dto;

import java.util.Date;

public class EventDTO {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 
     */
    private String podId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String message;

    /**
     * 
     */
    private String reason;

    /**
     * 
     */
    private String source;

    /**
     * 
     */
    private String type;

    /**
     * 
     */
    private Date createdTime;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getPodId() {
        return podId;
    }

    public void setPodId(String podId) {
        this.podId = podId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
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
}