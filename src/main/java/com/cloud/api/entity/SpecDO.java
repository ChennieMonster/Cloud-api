package com.cloud.api.entity;

import java.util.List;
import java.util.Map;

import com.cloud.api.model.ModelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

public class SpecDO implements ModelEntity{
	
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String host;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String, Object> selector;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer progressDeadlineSeconds;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer replicas;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Integer revisionHistoryLimit;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<PortsDO> ports;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private StrategyDO strategy;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private ToDO to;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String clusterIP;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private PodDO template;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String sessionAffinity;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String type;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Map<String,String> tls;
	
	public String getSessionAffinity() {
		return sessionAffinity;
	}

	public void setSessionAffinity(String sessionAffinity) {
		this.sessionAffinity = sessionAffinity;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public PodDO getTemplate() {
		return template;
	}

	public void setTemplate(PodDO template) {
		this.template = template;
	}

	public String getClusterIP() {
		return clusterIP;
	}

	public void setClusterIP(String clusterIP) {
		this.clusterIP = clusterIP;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Map<String, Object> getSelector() {
		return selector;
	}

	public void setSelector(Map<String, Object> selector) {
		this.selector = selector;
	}

	public Integer getProgressDeadlineSeconds() {
		return progressDeadlineSeconds;
	}

	public void setProgressDeadlineSeconds(Integer progressDeadlineSeconds) {
		this.progressDeadlineSeconds = progressDeadlineSeconds;
	}

	public Integer getReplicas() {
		return replicas;
	}

	public void setReplicas(Integer replicas) {
		this.replicas = replicas;
	}

	public Integer getRevisionHistoryLimit() {
		return revisionHistoryLimit;
	}

	public void setRevisionHistoryLimit(Integer revisionHistoryLimit) {
		this.revisionHistoryLimit = revisionHistoryLimit;
	}

	public StrategyDO getStrategy() {
		return strategy;
	}

	public void setStrategy(StrategyDO strategy) {
		this.strategy = strategy;
	}

	public List<PortsDO> getPorts() {
		return ports;
	}

	public void setPorts(List<PortsDO> ports) {
		this.ports = ports;
	}

	public ToDO getTo() {
		return to;
	}

	public void setTo(ToDO to) {
		this.to = to;
	}

	public Map<String, String> getTls() {
		return tls;
	}

	public void setTls(Map<String, String> tls) {
		this.tls = tls;
	}
	
}
