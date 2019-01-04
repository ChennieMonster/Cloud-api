package com.cloud.api.entity;

import com.cloud.api.model.ModelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @author huang_kefei
 * @date 2018年10月17日 类说明
 */
public class PodDO implements ModelEntity {

	private static final long serialVersionUID = 1L;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String apiVersion;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private String kind;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private MetaDataDO metadata;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	private PodSpecDO spec;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private StatusDO status;

	
	public StatusDO getStatus() {
		return status;
	}

	public void setStatus(StatusDO status) {
		this.status = status;
	}

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

	public PodSpecDO getSpec() {
		return spec;
	}

	public void setSpec(PodSpecDO spec) {
		this.spec = spec;
	}


}
