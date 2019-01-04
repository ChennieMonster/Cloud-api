package com.cloud.api.entity.response;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.StatusDO;
import com.cloud.api.model.ModelEntity;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
* @author huang_kefei
* @date 2018年11月11日
* 类说明
*/
public class DeploymentResponse implements ModelEntity{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
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
