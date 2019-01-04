package com.cloud.api.dto;

public class CicdStageInfoDTOWithBLOBs extends CicdStageInfoDTO {
    /**
     * 
     */
    private String log;

    /**
     * 
     */
    private String apiUrlLog;

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getApiUrlLog() {
        return apiUrlLog;
    }

    public void setApiUrlLog(String apiUrlLog) {
        this.apiUrlLog = apiUrlLog;
    }
}