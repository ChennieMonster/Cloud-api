package com.cloud.api.dto;

import java.util.Date;

public class UserSessionDTO {
    /**
     * 
     */
    private String uuid;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 上次选择region
     */
    private String regionId;

    /**
     * 上次选择project
     */
    private String projectId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}