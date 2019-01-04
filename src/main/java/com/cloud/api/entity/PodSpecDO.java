package com.cloud.api.entity;

import java.util.List;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年10月17日 类说明
 */
public class PodSpecDO {

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<ContainersDO> containers;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String dnsPolicy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String restartPolicy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String schedulerName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> imagePullSecrets;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String nodeName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, String> nodeSelector;

	/*
	 * securityContext: seLinuxOptions: level: s0:c11,c10
	 */
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CapabilitiesDO securityContext;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String serviceAccount;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String serviceAccountName;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer terminationGracePeriodSeconds;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<VolumeDO> volumes;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> tolerations;

	public List<Map<String, String>> getTolerations() {
		return tolerations;
	}

	public void setTolerations(List<Map<String, String>> tolerations) {
		this.tolerations = tolerations;
	}

	public List<ContainersDO> getContainers() {
		return containers;
	}

	public void setContainers(List<ContainersDO> containers) {
		this.containers = containers;
	}

	public String getDnsPolicy() {
		return dnsPolicy;
	}

	public void setDnsPolicy(String dnsPolicy) {
		this.dnsPolicy = dnsPolicy;
	}

	public String getRestartPolicy() {
		return restartPolicy;
	}

	public void setRestartPolicy(String restartPolicy) {
		this.restartPolicy = restartPolicy;
	}

	public String getSchedulerName() {
		return schedulerName;
	}

	public void setSchedulerName(String schedulerName) {
		this.schedulerName = schedulerName;
	}

	public List<Map<String, String>> getImagePullSecrets() {
		return imagePullSecrets;
	}

	public void setImagePullSecrets(List<Map<String, String>> imagePullSecrets) {
		this.imagePullSecrets = imagePullSecrets;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Map<String, String> getNodeSelector() {
		return nodeSelector;
	}

	public void setNodeSelector(Map<String, String> nodeSelector) {
		this.nodeSelector = nodeSelector;
	}


	public CapabilitiesDO getSecurityContext() {
		return securityContext;
	}

	public void setSecurityContext(CapabilitiesDO securityContext) {
		this.securityContext = securityContext;
	}

	public String getServiceAccount() {
		return serviceAccount;
	}

	public void setServiceAccount(String serviceAccount) {
		this.serviceAccount = serviceAccount;
	}

	public String getServiceAccountName() {
		return serviceAccountName;
	}

	public void setServiceAccountName(String serviceAccountName) {
		this.serviceAccountName = serviceAccountName;
	}

	public Integer getTerminationGracePeriodSeconds() {
		return terminationGracePeriodSeconds;
	}

	public void setTerminationGracePeriodSeconds(Integer terminationGracePeriodSeconds) {
		this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
	}

	public List<VolumeDO> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<VolumeDO> volumes) {
		this.volumes = volumes;
	}

}
