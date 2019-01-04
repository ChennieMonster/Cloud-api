package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NodeDTO {
    /**
     * 
     */
    private String uuid;

    /**
     * 
     */
    private String regionId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdtime;

    /**
     * 
     */
    private String internalIp;

    /**
     * 
     */
    private Integer podsNo;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedtime() {
        return createdtime;
    }

    public void setCreatedtime(Date createdtime) {
        this.createdtime = createdtime;
    }

    public String getInternalIp() {
        return internalIp;
    }

    public void setInternalIp(String internalIp) {
        this.internalIp = internalIp;
    }

    public Integer getPodsNo() {
        return podsNo;
    }

    public void setPodsNo(Integer podsNo) {
        this.podsNo = podsNo;
    }
}