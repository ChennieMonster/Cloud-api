package com.cloud.api.entity.response;

import java.util.List;

import com.cloud.api.entity.PortsDO;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年11月10日 类说明
 * service详细的返回值
 */
public class ServiceDetailResponse {
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String ip;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<PortsDO> ports;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String sessionAffinity;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String labels;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String instanceId;

	

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public List<PortsDO> getPorts() {
		return ports;
	}

	public void setPorts(List<PortsDO> ports) {
		this.ports = ports;
	}

	public String getSessionAffinity() {
		return sessionAffinity;
	}

	public void setSessionAffinity(String sessionAffinity) {
		this.sessionAffinity = sessionAffinity;
	}

}
