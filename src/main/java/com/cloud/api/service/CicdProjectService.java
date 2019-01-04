/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.CicdProcessInfoDTO;
import com.cloud.api.dto.CicdProjectDTO;
import com.cloud.api.dto.CicdStageInfoDTOWithBLOBs;
import com.cloud.api.entity.request.CicdProjectRequest;

/**
 * @author zhao_pengchen
 *
 */
public interface CicdProjectService {

	void addCicdProject(CicdProjectRequest cicdProjectRequest, String userName);
	
	List<CicdProjectDTO> cicdProjectList();

	List<CicdProcessInfoDTO> cicdProcessInfoList(String cicdProjectId);

	List<CicdStageInfoDTOWithBLOBs> cicdStageInfoList(String processId);
	
}
