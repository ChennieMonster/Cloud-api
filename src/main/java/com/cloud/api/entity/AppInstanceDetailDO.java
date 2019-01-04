package com.cloud.api.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.cloud.api.model.ModelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

public class AppInstanceDetailDO implements ModelEntity{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7132545030745719039L;

	@NotEmpty(message = "{appInstanceDetailDO.apiVersion.is.not.null}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String apiVersion;
	
	@NotEmpty(message = "{appInstanceDetailDO.kind.is.not.null}")
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String kind;
	
	@Valid
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MetaDataDO metadata;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private SpecDO spec;

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public MetaDataDO getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaDataDO metadata) {
		this.metadata = metadata;
	}

	public SpecDO getSpec() {
		return spec;
	}

	public void setSpec(SpecDO spec) {
		this.spec = spec;
	}

	@Override
	public String toString() {
		return "AppInstanceDO [apiVersion=" + apiVersion + ", kind=" + kind + ", metadata=" + metadata + ", spec="
				+ spec + "]";
	}
	
	
}
