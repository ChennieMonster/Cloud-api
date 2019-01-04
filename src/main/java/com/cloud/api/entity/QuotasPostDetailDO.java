/**
 * 
 */
package com.cloud.api.entity;

import com.cloud.api.model.ModelEntity;

/**
 * @author zhao_pengchen
 *
 */
public class QuotasPostDetailDO implements ModelEntity {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5338222126733083598L;

	private String kind;
	
	private String apiVersion;
	
	private MetaDataDO metadata;
	
	private ProjectSpecDO spec;

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

	public ProjectSpecDO getSpec() {
		return spec;
	}

	public void setSpec(ProjectSpecDO spec) {
		this.spec = spec;
	}
	
}
