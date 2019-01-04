package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MonitorNetworkDTO {
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
    private String netname;

    /**
     * 
     */
    private Long flowIn;

    /**
     * 
     */
    private Long flowOut;

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

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getNetname() {
        return netname;
    }

    public void setNetname(String netname) {
        this.netname = netname;
    }

    public Long getFlowIn() {
        return flowIn;
    }

    public void setFlowIn(Long flowIn) {
        this.flowIn = flowIn;
    }

    public Long getFlowOut() {
        return flowOut;
    }

    public void setFlowOut(Long flowOut) {
        this.flowOut = flowOut;
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

	public String getMonitorObjId() {
		return monitorObjId;
	}

	public void setMonitorObjId(String monitorObjId) {
		this.monitorObjId = monitorObjId;
	}
    
}