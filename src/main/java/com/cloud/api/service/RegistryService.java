/**
 * 
 */
package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.RegistryRequestData;

/**
 * @author zhao_pengchen
 *
 */
public interface RegistryService {

	boolean addRegistry(TokenDO token, RegistryRequestData requestData, String project, String regionId);

	boolean deleteRegistry(List<String> ids, TokenDO tokenDO, String project, String region);

	List<RegistryDTO> queryRegistryList(String project);

	boolean editRegistry(RegistryRequestData requestData, String registryId, TokenDO tokenDO, String project);

	RegistryDTO queryRegistryById(String registryId);

}
