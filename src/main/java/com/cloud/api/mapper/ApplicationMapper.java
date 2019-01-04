/**
 * 
 */
package com.cloud.api.mapper;

import java.util.List;

import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.ApplicationDTOExample;

/**
 * @author zhao_pengchen
 *
 */
public interface ApplicationMapper {

	List<ApplicationDTO> getApplications();
	
	int insertApplication(ApplicationDTO applicationDto);
	
	int deleteApplications(List<String> uuids);
	
	int updateApplication(ApplicationDTO applicationDTO);
	
	ApplicationDTO queryApplicationByUuid(String uuid);
	
    long countByExample(ApplicationDTOExample example);

    List<ApplicationDTO> selectByExample(ApplicationDTOExample example);
	
    ApplicationDTO queryApplicationByUuidByName(String name);
    
    List<ApplicationDTO> selectAppResourceByProject(String project);
}
