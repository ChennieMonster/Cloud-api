package com.cloud.api.dto;

import java.util.Date;

public class MonitorContainerDTO {
    /**
     * 
     */
    private String conCloudId;

    /**
     * 
     */
    private String uuid;

    /**
     * 
     */
    private String monitorObjId;

    /**
     * 
     */
    private String conDockerId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Long memory;

    /**
     * 
     */
    private Long memoryUsage;

    /**
     * 
     */
    private Float memoryUtil;

    /**
     * 
     */
    private Float cpuUtil;

    /**
     * 
     */
    private Long netIn;

    /**
     * 
     */
    private Long netOut;

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
    private Date createdTime;

    public String getConCloudId() {
        return conCloudId;
    }

    public void setConCloudId(String conCloudId) {
        this.conCloudId = conCloudId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMonitorObjId() {
        return monitorObjId;
    }

    public void setMonitorObjId(String monitorObjId) {
        this.monitorObjId = monitorObjId;
    }

    public String getConDockerId() {
        return conDockerId;
    }

    public void setConDockerId(String conDockerId) {
        this.conDockerId = conDockerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Float getMemoryUtil() {
        return memoryUtil;
    }

    public void setMemoryUtil(Float memoryUtil) {
        this.memoryUtil = memoryUtil;
    }

    public Float getCpuUtil() {
        return cpuUtil;
    }

    public void setCpuUtil(Float cpuUtil) {
        this.cpuUtil = cpuUtil;
    }

    public Long getNetIn() {
        return netIn;
    }

    public void setNetIn(Long netIn) {
        this.netIn = netIn;
    }

    public Long getNetOut() {
        return netOut;
    }

    public void setNetOut(Long netOut) {
        this.netOut = netOut;
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

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}