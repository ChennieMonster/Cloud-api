package com.cloud.api.core.type;

public enum ServiceType {

	OPENSHIFT("openshift", "openshift"),
	UNKNOWN("NA", "NA")
	;
	
	private final String serviceName;
	private final String type;

	ServiceType(String serviceName, String type) {
		this.serviceName = serviceName;
		this.type = type;
	}

	public String getServiceName() {
		return this.serviceName;
	}

	public String getType() {
		return this.type;
	}
}
