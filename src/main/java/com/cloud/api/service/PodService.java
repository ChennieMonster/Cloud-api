/**
 * 
 */
package com.cloud.api.service;


import java.util.List;

import com.cloud.api.dto.PodDTO;
import com.cloud.api.entity.PodDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.response.PodResponseData;

/**
 * @author zhao_pengchen
 *
 */
public interface PodService {

	int deletePod(String setId,TokenDO token,String project);
	
	int updatePod(PodDO podDO,String podId,String podName,TokenDO token);
	
	List<PodResponseData> getPodList(String instanceId);
	
	long countPod();
	
}
