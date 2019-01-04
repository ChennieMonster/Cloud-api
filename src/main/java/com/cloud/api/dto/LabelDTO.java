package com.cloud.api.dto;

public class LabelDTO {
    /**
     * 
     */
    private String uuid;

    /**
     * 
     */
    private String nodeId;

    /**
     * 
     */
    private String labelKey;

    /**
     * 
     */
    private String labelValue;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getLabelKey() {
        return labelKey;
    }

    public void setLabelKey(String labelKey) {
        this.labelKey = labelKey;
    }

    public String getLabelValue() {
        return labelValue;
    }

    public void setLabelValue(String labelValue) {
        this.labelValue = labelValue;
    }
}