/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.NodeDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.LabelRequest;
import com.cloud.api.entity.response.NodeResponse;

/**
 * @author zhao_pengchen
 *
 */
public interface NodeService {

	List<NodeDTO> getNodeList(String regionId);
	
	NodeResponse getNodeDetail(String nodeId);
	
	void updateLabels(LabelRequest request, TokenDO token);
	
	
}
