package com.cloud.api.entity;

import com.cloud.api.model.ModelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

public class PortsDO implements ModelEntity{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer port;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer targetPort;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer containerPort;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String protocol;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getTargetPort() {
		return targetPort;
	}

	public void setTargetPort(Integer targetPort) {
		this.targetPort = targetPort;
	}

	public Integer getContainerPort() {
		return containerPort;
	}

	public void setContainerPort(Integer containerPort) {
		this.containerPort = containerPort;
	}

	public String getProtocol() {
		return protocol;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}
	
	
}
