package com.cloud.api.entity;

public class ProbeDO {
	
	private Integer failureThreshold;
	
	private ExecDO exec;
	
	private HttpGetDO httpGet;
	
	private TcpSocketDO tcpSocket;
	
	private Integer initialDelaySeconds;
	
	private Integer periodSeconds;
	
	private Integer successThreshold;
	
	private Integer timeoutSeconds;
	
	public Integer getFailureThreshold() {
		return failureThreshold;
	}

	public void setFailureThreshold(Integer failureThreshold) {
		this.failureThreshold = failureThreshold;
	}

	public ExecDO getExec() {
		return exec;
	}

	public void setExec(ExecDO exec) {
		this.exec = exec;
	}

	public HttpGetDO getHttpGet() {
		return httpGet;
	}

	public void setHttpGet(HttpGetDO httpGet) {
		this.httpGet = httpGet;
	}

	public TcpSocketDO getTcpSocket() {
		return tcpSocket;
	}

	public void setTcpSocket(TcpSocketDO tcpSocket) {
		this.tcpSocket = tcpSocket;
	}

	public Integer getInitialDelaySeconds() {
		return initialDelaySeconds;
	}

	public void setInitialDelaySeconds(Integer initialDelaySeconds) {
		this.initialDelaySeconds = initialDelaySeconds;
	}

	public Integer getPeriodSeconds() {
		return periodSeconds;
	}

	public void setPeriodSeconds(Integer periodSeconds) {
		this.periodSeconds = periodSeconds;
	}

	public Integer getSuccessThreshold() {
		return successThreshold;
	}

	public void setSuccessThreshold(Integer successThreshold) {
		this.successThreshold = successThreshold;
	}

	public Integer getTimeoutSeconds() {
		return timeoutSeconds;
	}

	public void setTimeoutSeconds(Integer timeoutSeconds) {
		this.timeoutSeconds = timeoutSeconds;
	}
	
	
}
