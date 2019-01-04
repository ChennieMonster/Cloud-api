package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MonitorDiskIoDTO {
    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private String monitorObjId;

    /**
     * 
     */
    private String hostname;

    /**
     * 
     */
    private String diskName;

    /**
     * 
     */
    private Float rps;

    /**
     * 
     */
    private Float wps;

    /**
     * 
     */
    private Integer clock;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMonitorObjId() {
        return monitorObjId;
    }

    public void setMonitorObjId(String monitorObjId) {
        this.monitorObjId = monitorObjId;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getDiskName() {
        return diskName;
    }

    public void setDiskName(String diskName) {
        this.diskName = diskName;
    }

    public Float getRps() {
        return rps;
    }

    public void setRps(Float rps) {
        this.rps = rps;
    }

    public Float getWps() {
        return wps;
    }

    public void setWps(Float wps) {
        this.wps = wps;
    }

    public Integer getClock() {
        return clock;
    }

    public void setClock(Integer clock) {
        this.clock = clock;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}