/**
 * 
 */
package com.cloud.api.entity.request;

import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.model.ModelEntity;

/**
 * @author zhao_pengchen
 *
 */
public class LabelPostRequest implements ModelEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2281132114172960616L;

	private MetaDataDO metadata;
	
	private String namespace;

	public MetaDataDO getMetadata() {
		return metadata;
	}

	public void setMetadata(MetaDataDO metadata) {
		this.metadata = metadata;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

}
