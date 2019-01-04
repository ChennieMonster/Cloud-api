package com.cloud.api.dto;

import java.util.Date;

public class AppMarketVersionDTO {
    /**
     * 
     */
    private String uuid;

    /**
     * 
     */
    private String marketId;

    /**
     * 
     */
    private String version;

    /**
     * 
     */
    private Date createdTime;

    /**
     * 
     */
    private String introduce;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMarketId() {
        return marketId;
    }

    public void setMarketId(String marketId) {
        this.marketId = marketId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }
}