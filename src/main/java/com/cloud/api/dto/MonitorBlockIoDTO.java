package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MonitorBlockIoDTO {
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
    private Long blockIn;

    /**
     * 
     */
    private Long blockOut;

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

    public Long getBlockIn() {
        return blockIn;
    }

    public void setBlockIn(Long blockIn) {
        this.blockIn = blockIn;
    }

    public Long getBlockOut() {
        return blockOut;
    }

    public void setBlockOut(Long blockOut) {
        this.blockOut = blockOut;
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