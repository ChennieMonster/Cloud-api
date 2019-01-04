package com.cloud.api.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TagDTO {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 
     */
    private String imageId;

    /**
     * 名称
     */
    private String name;

    /**
     * 大小（MB）
     */
    private Long size;

    /**
     * 更改日志
     */
    private String changelog;

    /**
     * 
     */
    private String env;

    /**
     * 
     */
    private String volume;

    /**
     * 
     */
    private Integer markFlag;

    /**
     * 
     */
    private String port;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    /**
     * 
     */
    private String cmd;
    
    private List<LayerDTO> layers;
    
    public List<LayerDTO> getLayers() {
		return layers;
	}

	public void setLayers(List<LayerDTO> layers) {
		this.layers = layers;
	}

	public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getChangelog() {
        return changelog;
    }

    public void setChangelog(String changelog) {
        this.changelog = changelog;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public Integer getMarkFlag() {
        return markFlag;
    }

    public void setMarkFlag(Integer markFlag) {
        this.markFlag = markFlag;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

	@Override
	public String toString() {
		return "TagDTO [uuid=" + uuid + ", imageId=" + imageId + ", name=" + name + ", size=" + size + ", changelog="
				+ changelog + ", env=" + env + ", volume=" + volume + ", markFlag=" + markFlag + ", port=" + port
				+ ", createdTime=" + createdTime + ", cmd=" + cmd + "]";
	}
    
}