package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CicdStageInfoDTO {
    /**
     * 
     */
    private String uuid;

    /**
     * 
     */
    private String processId;

    /**
     * 
     */
    private String nodeId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer status;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date beginTime;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date endTime;

    /**
     * 
     */
    private Long durationMillis;

    /**
     * 
     */
    private String apiUrlStage;

    /**
     * 
     */
    private String codePath;

    /**
     * 
     */
    private String compileFilePath;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Long getDurationMillis() {
        return durationMillis;
    }

    public void setDurationMillis(Long durationMillis) {
        this.durationMillis = durationMillis;
    }

    public String getApiUrlStage() {
        return apiUrlStage;
    }

    public void setApiUrlStage(String apiUrlStage) {
        this.apiUrlStage = apiUrlStage;
    }

    public String getCodePath() {
        return codePath;
    }

    public void setCodePath(String codePath) {
        this.codePath = codePath;
    }

    public String getCompileFilePath() {
        return compileFilePath;
    }

    public void setCompileFilePath(String compileFilePath) {
        this.compileFilePath = compileFilePath;
    }
}