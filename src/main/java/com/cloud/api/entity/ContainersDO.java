package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年10月17日 类说明
 */
public class ContainersDO {
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String image;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String imagePullPolicy;
	
	private List<ImagePullSecretsDO> imagePullSecrets;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String name;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<PortsDO> ports;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ResourcesDO resources;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, Object>> env;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, Object> valueFrom;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String terminationMessagePath;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String terminationMessagePolicy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private CapabilitiesDO securityContext;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<Map<String, String>> volumeMounts;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<String> command;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ProbeDO livenessProbe;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ProbeDO readinessProbe;
	
	public ProbeDO getLivenessProbe() {
		return livenessProbe;
	}

	public void setLivenessProbe(ProbeDO livenessProbe) {
		this.livenessProbe = livenessProbe;
	}

	public ProbeDO getReadinessProbe() {
		return readinessProbe;
	}

	public void setReadinessProbe(ProbeDO readinessProbe) {
		this.readinessProbe = readinessProbe;
	}

	public CapabilitiesDO getSecurityContext() {
		return securityContext;
	}

	public void setSecurityContext(CapabilitiesDO securityContext) {
		this.securityContext = securityContext;
	}

	public List<Map<String, String>> getVolumeMounts() {
		return volumeMounts;
	}

	public void setVolumeMounts(List<Map<String, String>> volumeMounts) {
		this.volumeMounts = volumeMounts;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImagePullPolicy() {
		return imagePullPolicy;
	}

	public void setImagePullPolicy(String imagePullPolicy) {
		this.imagePullPolicy = imagePullPolicy;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<PortsDO> getPorts() {
		return ports;
	}

	public void setPorts(List<PortsDO> ports) {
		this.ports = ports;
	}
	
	public ResourcesDO getResources() {
		return resources;
	}

	public void setResources(ResourcesDO resources) {
		this.resources = resources;
	}

	public String getTerminationMessagePath() {
		return terminationMessagePath;
	}

	public void setTerminationMessagePath(String terminationMessagePath) {
		this.terminationMessagePath = terminationMessagePath;
	}

	public String getTerminationMessagePolicy() {
		return terminationMessagePolicy;
	}

	public void setTerminationMessagePolicy(String terminationMessagePolicy) {
		this.terminationMessagePolicy = terminationMessagePolicy;
	}

	public List<String> getCommand() {
		return command;
	}

	public void setCommand(List<String> command) {
		this.command = command;
	}

	public List<Map<String, Object>> getEnv() {
		return env;
	}

	public void setEnv(List<Map<String, Object>> env) {
		this.env = env;
	}

	public Map<String, Object> getValueFrom() {
		return valueFrom;
	}

	public void setValueFrom(Map<String, Object> valueFrom) {
		this.valueFrom = valueFrom;
	}

	public List<ImagePullSecretsDO> getImagePullSecrets() {
		return imagePullSecrets;
	}

	public void setImagePullSecrets(List<ImagePullSecretsDO> imagePullSecrets) {
		this.imagePullSecrets = imagePullSecrets;
	}

}
