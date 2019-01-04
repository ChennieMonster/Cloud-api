package com.cloud.api.dto;


public class ResourceQuotaDTO {
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
    private String project;

    /**
     * 
     */
    private Double cpuTotal;

    /**
     * 
     */
    private Double cpuUsed;

    /**
     * 
     */
    private Double cpuRest;

    /**
     * 
     */
    private Double memoryTotal;

    /**
     * 
     */
    private Double memoryUsed;

    /**
     * 
     */
    private Double memoryRest;

    /**
     * 
     */
    private Integer podsTotal;

    /**
     * 
     */
    private Integer podsUsed;

    /**
     * 
     */
    private Integer podsRest;

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

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public Double getCpuTotal() {
        return cpuTotal;
    }

    public void setCpuTotal(Double cpuTotal) {
        this.cpuTotal = cpuTotal;
    }

    public Double getCpuUsed() {
        return cpuUsed;
    }

    public void setCpuUsed(Double cpuUsed) {
        this.cpuUsed = cpuUsed;
    }

    public Double getCpuRest() {
        return cpuRest;
    }

    public void setCpuRest(Double cpuRest) {
        this.cpuRest = cpuRest;
    }

    public Double getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(Double memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public Double getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(Double memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public Double getMemoryRest() {
        return memoryRest;
    }

    public void setMemoryRest(Double memoryRest) {
        this.memoryRest = memoryRest;
    }

    public Integer getPodsTotal() {
        return podsTotal;
    }

    public void setPodsTotal(Integer podsTotal) {
        this.podsTotal = podsTotal;
    }

    public Integer getPodsUsed() {
        return podsUsed;
    }

    public void setPodsUsed(Integer podsUsed) {
        this.podsUsed = podsUsed;
    }

    public Integer getPodsRest() {
        return podsRest;
    }

    public void setPodsRest(Integer podsRest) {
        this.podsRest = podsRest;
    }
}