package com.cloud.api.util;


import org.springframework.stereotype.Component;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ParamInvalidException;

/**
 * @author huang_kefei
 * @date 2018年11月27日 类说明
 */
@Component
public class ResourceValidUtils {
	
	public double memoryUnit(String memoryStr,String type) {
		double memory = 0;
		if (memoryStr.indexOf("Ki") > 0) {
			String str = memoryStr.substring(0, memoryStr.indexOf("Ki"));
			memory = Double.parseDouble(str) / 1024;
		} else if (memoryStr.indexOf("Mi") > 0) {
			String str = memoryStr.substring(0, memoryStr.indexOf("Mi"));
			memory = Double.parseDouble(str);
		} else if (memoryStr.indexOf("Gi") > 0) {
			String str = memoryStr.substring(0, memoryStr.indexOf("Gi"));
			memory = Double.parseDouble(str) * 1024;
		} else if (memoryStr.matches("^[0-9]*$")) {
			memory = Double.parseDouble(memoryStr);
		} else {
			if(Constants.RESOURCE_REQUESTS.equals(type)) {
				throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.memory.is.illegal"));
			}else if(Constants.RESOURCE_LIMITS.equals(type)){
				throw new ParamInvalidException(MessageUtils.getMessage("resource.limits.memory.is.illegal"));
			}
		}
		return memory;
	}

	public double cpuUnit(String cpuStr,String type) {
		double cpu = 0;
		if (cpuStr.indexOf("m") > 0) {
			cpu = Double.parseDouble(cpuStr.substring(0, cpuStr.indexOf("m"))) / 1000;
		} else if (cpuStr.matches("^[0-9]*$")) {
			cpu = Double.parseDouble(cpuStr);
		} else {
			if(Constants.RESOURCE_REQUESTS.equals(type)) {
				throw new ParamInvalidException(MessageUtils.getMessage("resource.requests.cpu.is.illegal"));
			}else if(Constants.RESOURCE_LIMITS.equals(type)){
				throw new ParamInvalidException(MessageUtils.getMessage("resource.limits.cpu.is.illegal"));
			}
		}
		return cpu;
	}
}
