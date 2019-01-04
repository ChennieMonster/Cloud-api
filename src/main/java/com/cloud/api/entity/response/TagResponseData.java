package com.cloud.api.entity.response;

import java.util.List;
import java.util.Map;

import com.cloud.api.dto.LayerDTO;
import com.fasterxml.jackson.annotation.JsonInclude;

public class TagResponseData {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String uuid;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String imageId;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Long size;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String changelog;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> env;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> volume;

	private List<LayerDTO> layers;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String cmd;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String port;
	
	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
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

	public List<Map<String, String>> getEnv() {
		return env;
	}

	public void setEnv(List<Map<String, String>> env) {
		this.env = env;
	}

	public List<String> getVolume() {
		return volume;
	}

	public void setVolume(List<String> volume) {
		this.volume = volume;
	}

	public List<LayerDTO> getLayers() {
		return layers;
	}

	public void setLayers(List<LayerDTO> layers) {
		this.layers = layers;
	}

}
