package com.cloud.api.entity;

/**
 * @author huang_kefei
 * @date 2018年11月6日 类说明
 */
public class SetDO {

	private String apiVersion;
	private String kind;
	private MetaDataDO metadata;
	private SpecDO spec;
	private StatusDO status;

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

	public StatusDO getStatus() {
		return status;
	}

	public void setStatus(StatusDO status) {
		this.status = status;
	}

}
