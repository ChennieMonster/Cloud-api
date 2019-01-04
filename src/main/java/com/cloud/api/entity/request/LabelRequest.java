/**
 * 
 */
package com.cloud.api.entity.request;

import java.util.Map;

import javax.validation.constraints.NotEmpty;

/**
 * @author zhao_pengchen
 *
 */
public class LabelRequest {

	@NotEmpty(message = "{labels.null}")
	private Map<String, String> labels;
	
	private String nodeId;

	public Map<String, String> getLabels() {
		return labels;
	}

	public void setLabels(Map<String, String> labels) {
		this.labels = labels;
	}

	public String getNodeId() {
		return nodeId;
	}

	public void setNodeId(String nodeId) {
		this.nodeId = nodeId;
	}
	
}
