package com.cloud.api.entity;

import java.util.List;

/**
 * mq消息传输对象,转json传输
 * 
 * @author shi_lin
 *
 */
public class MqMessage {
	/**
	 * 调用os url
	 */
	private String instanceId;

	private String url;

	/**
	 * uuid
	 */
	private String uuid;

	/**
	 * 处理的资源类型
	 */
	private String kind;

	/**
	 * token对象
	 */
	private TokenDO tokenDO;

	private String deploymentName;

	private List<String> podId;

	private String project;

	private String region;

	private String registryId;

	private String type;

	private String imageName;

	private String tagName;

	private String registryUrl;

	private String sercviceName;

	private String routName;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSercviceName() {
		return sercviceName;
	}

	public void setSercviceName(String sercviceName) {
		this.sercviceName = sercviceName;
	}

	public String getRoutName() {
		return routName;
	}

	public void setRoutName(String routName) {
		this.routName = routName;
	}

	public String getInstanceId() {
		return instanceId;
	}

	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getRegistryUrl() {
		return registryUrl;
	}

	public void setRegistryUrl(String registryUrl) {
		this.registryUrl = registryUrl;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getTagName() {
		return tagName;
	}

	public void setTagName(String tagName) {
		this.tagName = tagName;
	}

	public List<String> getPodId() {
		return podId;
	}

	public void setPodId(List<String> podId) {
		this.podId = podId;
	}

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public TokenDO getTokenDO() {
		return tokenDO;
	}

	public void setTokenDO(TokenDO tokenDO) {
		this.tokenDO = tokenDO;
	}

	public String getRegistryId() {
		return registryId;
	}

	public void setRegistryId(String registryId) {
		this.registryId = registryId;
	}

}
