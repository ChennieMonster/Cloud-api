package com.cloud.api.dto;

public class RegionDTO {
    /**
     * 地区ID
     */
    private String uuid;

    /**
     * 地区名称
     */
    private String name;

    /**
     * 
     */
    private String openshiftUrl;

    /**
     * 
     */
    private String containerUrl;

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

    public String getOpenshiftUrl() {
        return openshiftUrl;
    }

    public void setOpenshiftUrl(String openshiftUrl) {
        this.openshiftUrl = openshiftUrl;
    }

    public String getContainerUrl() {
        return containerUrl;
    }

    public void setContainerUrl(String containerUrl) {
        this.containerUrl = containerUrl;
    }
}