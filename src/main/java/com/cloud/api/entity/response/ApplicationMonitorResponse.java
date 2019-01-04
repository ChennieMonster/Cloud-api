package com.cloud.api.entity.response;

public class ApplicationMonitorResponse {
	
	private float cpuUtil;
	
	private long memoryTotal;
	
	private long memoryUsage;
	
	private long netIn;
	
	private long netOut;
	
	private long blockIn;
	
	private long blockOut;
	
	public ApplicationMonitorResponse() {
		super();
	}

	public ApplicationMonitorResponse(float cpuUtil, long memoryTotal, long memoryUsage, long netIn, long netOut,
			long blockIn, long blockOut) {
		super();
		this.cpuUtil = cpuUtil;
		this.memoryTotal = memoryTotal;
		this.memoryUsage = memoryUsage;
		this.netIn = netIn;
		this.netOut = netOut;
		this.blockIn = blockIn;
		this.blockOut = blockOut;
	}

	public float getCpuUtil() {
		return cpuUtil;
	}

	public void setCpuUtil(float cpuUtil) {
		this.cpuUtil = cpuUtil;
	}

	public long getMemoryTotal() {
		return memoryTotal;
	}

	public void setMemoryTotal(long memoryTotal) {
		this.memoryTotal = memoryTotal;
	}

	public long getMemoryUsage() {
		return memoryUsage;
	}

	public void setMemoryUsage(long memoryUsage) {
		this.memoryUsage = memoryUsage;
	}

	public long getNetIn() {
		return netIn;
	}

	public void setNetIn(long netIn) {
		this.netIn = netIn;
	}

	public long getNetOut() {
		return netOut;
	}

	public void setNetOut(long netOut) {
		this.netOut = netOut;
	}

	public long getBlockIn() {
		return blockIn;
	}

	public void setBlockIn(long blockIn) {
		this.blockIn = blockIn;
	}

	public long getBlockOut() {
		return blockOut;
	}

	public void setBlockOut(long blockOut) {
		this.blockOut = blockOut;
	}
	
}
