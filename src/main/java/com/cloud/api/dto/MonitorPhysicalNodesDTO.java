package com.cloud.api.dto;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class MonitorPhysicalNodesDTO {
	
	/**
     * 
     */
    private String nodeId;
    
    /**
     * 
     */
    private String hostname;

    /**
     * 
     */
    private String id;

    /**
     * 
     */
    private Integer cpu;

    /**
     * 
     */
    private Float cpuUtil;

    /**
     * 
     */
    private Long memory;

    /**
     * 
     */
    private Long memoryUsage;

    /**
     * 
     */
    private Long disk;

    /**
     * 
     */
    private Long diskUsage;

    /**
     * 
     */
    private Long netIfIn;

    /**
     * 
     */
    private Long netIfOut;

    /**
     * 
     */
    private String os;

    /**
     * 
     */
    private String product;

    /**
     * 
     */
    private String source;

    /**
     * 
     */
    private String ip;

    /**
     * 
     */
    private String status;
    
    private Map<String,Map<String, Float>> diskIo;
    
    public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}

	public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getCpu() {
        return cpu;
    }

    public void setCpu(Integer cpu) {
        this.cpu = cpu;
    }

    public Float getCpuUtil() {
        return cpuUtil;
    }

    public void setCpuUtil(Float cpuUtil) {
        this.cpuUtil = cpuUtil;
    }

    public Long getMemory() {
        return memory;
    }

    public void setMemory(Long memory) {
        this.memory = memory;
    }

    public Long getMemoryUsage() {
        return memoryUsage;
    }

    public void setMemoryUsage(Long memoryUsage) {
        this.memoryUsage = memoryUsage;
    }

    public Long getDisk() {
        return disk;
    }

    public void setDisk(Long disk) {
        this.disk = disk;
    }

    public Long getDiskUsage() {
        return diskUsage;
    }

    public void setDiskUsage(Long diskUsage) {
        this.diskUsage = diskUsage;
    }

    public Long getNetIfIn() {
        return netIfIn;
    }

    public void setNetIfIn(Long netIfIn) {
        this.netIfIn = netIfIn;
    }

    public Long getNetIfOut() {
        return netIfOut;
    }

    public void setNetIfOut(Long netIfOut) {
        this.netIfOut = netIfOut;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	public Map<String, Map<String, Float>> getDiskIo() {
		return diskIo;
	}

	public void setDiskIo(Map<String, Map<String, Float>> diskIo) {
		this.diskIo = diskIo;
	}

}