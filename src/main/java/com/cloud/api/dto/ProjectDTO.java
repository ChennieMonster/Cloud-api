package com.cloud.api.dto;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ProjectDTO {
    /**
     * 閮ㄩ棬ID
     */
    private String uuid;

    /**
     * 闂侇喓鍔戝Λ顒勫触瀹ュ�?
     */
    private String name;

    /**
     * 闂侇喓鍔戝Λ顒傜驳婢跺矂鐛?
     */
    private String displayName;

    /**
     * 
     */
    private String description;

    /**
     * 
     */
    private BigDecimal cpuQuota;

    /**
     * 
     */
    private BigDecimal memoryQuota;

    /**
     * 
     */
    private Integer podsQuota;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date updatedTime;

    /**
     * 0-�����д����� ��1-�����У�2-����������3����
     */
    private Integer approveStatus;

    /**
     * 
     */
    private String taskId;

    /**
     * 
     */
    private String applyUser;

    /**
     * 
     */
    private Integer diskQuota;

    /**
     * 0-δ�޸ģ�1-�����޸��У�2-�޸���������
     */
    private Integer updateStatus;

    /**
     * 
     */
    private String regionId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getCpuQuota() {
        return cpuQuota;
    }

    public void setCpuQuota(BigDecimal cpuQuota) {
        this.cpuQuota = cpuQuota;
    }

    public BigDecimal getMemoryQuota() {
        return memoryQuota;
    }

    public void setMemoryQuota(BigDecimal memoryQuota) {
        this.memoryQuota = memoryQuota;
    }

    public Integer getPodsQuota() {
        return podsQuota;
    }

    public void setPodsQuota(Integer podsQuota) {
        this.podsQuota = podsQuota;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    public Integer getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Integer approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getApplyUser() {
        return applyUser;
    }

    public void setApplyUser(String applyUser) {
        this.applyUser = applyUser;
    }

    public Integer getDiskQuota() {
        return diskQuota;
    }

    public void setDiskQuota(Integer diskQuota) {
        this.diskQuota = diskQuota;
    }

    public Integer getUpdateStatus() {
        return updateStatus;
    }

    public void setUpdateStatus(Integer updateStatus) {
        this.updateStatus = updateStatus;
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }
}