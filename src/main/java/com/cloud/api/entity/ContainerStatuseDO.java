package com.cloud.api.entity;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年11月2日 类说明
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContainerStatuseDO {
	
	private String containerID;

	private String image;

	private String imageID;

	private Map<String,Object> lastState;

	private String name;

	private boolean ready;

	private Integer restartCount;

	private Map<String,Map<String,String>> state;

	public String getContainerID() {
		return containerID;
	}

	public void setContainerID(String containerID) {
		this.containerID = containerID;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageID() {
		return imageID;
	}

	public void setImageID(String imageID) {
		this.imageID = imageID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Integer getRestartCount() {
		return restartCount;
	}

	public void setRestartCount(Integer restartCount) {
		this.restartCount = restartCount;
	}


	public Map<String, Map<String, String>> getState() {
		return state;
	}

	public void setState(Map<String, Map<String, String>> state) {
		this.state = state;
	}

	public Map<String, Object> getLastState() {
		return lastState;
	}

	public void setLastState(Map<String, Object> lastState) {
		this.lastState = lastState;
	}

	public boolean isReady() {
		return ready;
	}

	public void setReady(boolean ready) {
		this.ready = ready;
	}


}
