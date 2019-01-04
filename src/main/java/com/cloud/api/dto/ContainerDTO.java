package com.cloud.api.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ContainerDTO {
    /**
     * 
     */
    private String uuid;

    /**
     * 
     */
    private String conId;

    /**
     * 
     */
    private String podId;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private String image;

    /**
     * 
     */
    private String resources;

    /**
     * 
     */
    private Integer processId;

    /**
     * 
     */
    private String workDir;

    /**
     * 
     */
    private String nodeName;

    /**
     * 
     */
    private String env;

    /**
     * 
     */
    private String args;

    /**
     * 
     */
    private String volumes;

    /**
     * 
     */
    private String mounts;

    /**
     * 
     */
    private String exposedPorts;

    /**
     * 
     */
    private String ports;

    /**
     * 
     */
    private String entrypoint;

    /**
     * 
     */
    private String cmd;

    /**
     * 
     */
    private String domainName;

    /**
     * 
     */
    private String hostname;

    /**
     * 
     */
    private String ipAddress;

    /**
     * 
     */
    private String status;

    /**
     * 
     */
    private String exitCode;

    /**
     * 
     */
    private String error;

    /**
     * 
     */
    private String conDetail;

    /**
     * 
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date createdTime;

    /**
     * 
     */
    private String dns;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getConId() {
        return conId;
    }

    public void setConId(String conId) {
        this.conId = conId;
    }

    public String getPodId() {
        return podId;
    }

    public void setPodId(String podId) {
        this.podId = podId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
    }

    public String getWorkDir() {
        return workDir;
    }

    public void setWorkDir(String workDir) {
        this.workDir = workDir;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getVolumes() {
        return volumes;
    }

    public void setVolumes(String volumes) {
        this.volumes = volumes;
    }

    public String getMounts() {
        return mounts;
    }

    public void setMounts(String mounts) {
        this.mounts = mounts;
    }

    public String getExposedPorts() {
        return exposedPorts;
    }

    public void setExposedPorts(String exposedPorts) {
        this.exposedPorts = exposedPorts;
    }

    public String getPorts() {
        return ports;
    }

    public void setPorts(String ports) {
        this.ports = ports;
    }

    public String getEntrypoint() {
        return entrypoint;
    }

    public void setEntrypoint(String entrypoint) {
        this.entrypoint = entrypoint;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getDomainName() {
        return domainName;
    }

    public void setDomainName(String domainName) {
        this.domainName = domainName;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExitCode() {
        return exitCode;
    }

    public void setExitCode(String exitCode) {
        this.exitCode = exitCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getConDetail() {
        return conDetail;
    }

    public void setConDetail(String conDetail) {
        this.conDetail = conDetail;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getDns() {
        return dns;
    }

    public void setDns(String dns) {
        this.dns = dns;
    }
}