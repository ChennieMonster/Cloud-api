package com.cloud.api.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LayerDTO {
    /**
     * 主键
     */
    private String uuid;

    /**
     * 名称
     */
    private String name;

    /**
     * tagId
     */
    private String tagId;

    /**
     * 大小
     */
    private Long size;

    /**
     * 
     */
    private String mediaType;

    /**
     * 哈希值
     */
    private String layerHash;

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

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public String getMediaType() {
        return mediaType;
    }

    public void setMediaType(String mediaType) {
        this.mediaType = mediaType;
    }

    public String getLayerHash() {
        return layerHash;
    }

    public void setLayerHash(String layerHash) {
        this.layerHash = layerHash;
    }
}