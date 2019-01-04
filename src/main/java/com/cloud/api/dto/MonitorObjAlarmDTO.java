package com.cloud.api.dto;

import io.swagger.annotations.ApiModelProperty;

public class MonitorObjAlarmDTO {
    /**
     * 
     */
	@ApiModelProperty(hidden=true)
    private String uuid;

    /**
     * 
     */
    private String monitorAlarmId;

    /**
     * 
     */
    private String monitorObjId;

    /**
     * enable/disable
     */
    @ApiModelProperty(hidden=true)
    private String status;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getMonitorAlarmId() {
        return monitorAlarmId;
    }

    public void setMonitorAlarmId(String monitorAlarmId) {
        this.monitorAlarmId = monitorAlarmId;
    }

    public String getMonitorObjId() {
        return monitorObjId;
    }

    public void setMonitorObjId(String monitorObjId) {
        this.monitorObjId = monitorObjId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}