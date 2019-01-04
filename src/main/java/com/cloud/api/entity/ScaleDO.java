package com.cloud.api.entity;

import com.cloud.api.model.ModelEntity;

/**
 * @author huang_kefei
 * @date 2018年11月11日 类说明
 */
public class ScaleDO implements ModelEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String kind;
	private String apiVersion;
	private MetaDataDO metadata;
	private SpecDO spec;
	private StatusDO status;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getApiVersion() {
		return apiVersion;
	}

	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
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

	public StatusDO getStatus() {
		return status;
	}

	public void setStatus(StatusDO status) {
		this.status = status;
	}

}
