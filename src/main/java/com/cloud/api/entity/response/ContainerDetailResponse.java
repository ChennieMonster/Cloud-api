package com.cloud.api.entity.response;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * @author huang_kefei
 * @date 2018年12月17日 类说明
 * container详细
 */
public class ContainerDetailResponse {

	private String conId;
	
	private String name;

	private String nodeName;

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
	private Date createdTime;

	private String con_detail;

	private String Image;

	private String status;

	// 进程
	private Integer processId;

	// 工作目录
	private String workDir;

	// 环境变量
	private List<Map<String,String>> env;

	// network
	private String domainName;
	
	private String hostName;

	private String ip;

	private Map<String,List<Map<String,Object>>> ports;

	private String dns;
	
	//挂载路径
	private List<String> volumes;
	
	private List<Map<String,Object>> mounts;


	public String getWorkDir() {
		return workDir;
	}

	public List<Map<String, String>> getEnv() {
		return env;
	}

	public void setEnv(List<Map<String, String>> env) {
		this.env = env;
	}
	
	public Map<String, List<Map<String, Object>>> getPorts() {
		return ports;
	}

	public void setPorts(Map<String, List<Map<String, Object>>> ports) {
		this.ports = ports;
	}

	public List<String> getVolumes() {
		return volumes;
	}

	public void setVolumes(List<String> volumes) {
		this.volumes = volumes;
	}

	public List<Map<String, Object>> getMounts() {
		return mounts;
	}

	public void setMounts(List<Map<String, Object>> mounts) {
		this.mounts = mounts;
	}

	public Integer getProcessId() {
		return processId;
	}

	public void setProcessId(Integer processId) {
		this.processId = processId;
	}

	public void setWorkDir(String workDir) {
		this.workDir = workDir;
	}


	public String getDomainName() {
		return domainName;
	}

	public void setDomainName(String domainName) {
		this.domainName = domainName;
	}

	public String getDns() {
		return dns;
	}

	public void setDns(String dns) {
		this.dns = dns;
	}


	public String getConId() {
		return conId;
	}

	public void setConId(String conId) {
		this.conId = conId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getCon_detail() {
		return con_detail;
	}

	public void setCon_detail(String con_detail) {
		this.con_detail = con_detail;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}
	
}
