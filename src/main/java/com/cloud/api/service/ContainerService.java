package com.cloud.api.service;

import java.util.List;

import com.cloud.api.dto.ContainerDTO;
import com.cloud.api.entity.ContainerDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ContainerRequestData;

/**
 * @author shi_lin
 */
public interface ContainerService {
	
	int addContainer(ContainerDO containerDO,String podId,TokenDO token);

	int deleteContainer(String podId);

	int updateContainer(ContainerDO containerDO,String containerId,String containerName,TokenDO token);
	
	int operateContainer(String containerId, ContainerRequestData requestData,String project);
	
	ContainerDTO queryContainerById(String containerId);
	
	List<ContainerDTO> queryContainerByPodId(String podId);
	
	int editContainer(String containerId, ContainerRequestData requestData);
	
	ContainerDTO queryContainerByConId(String containerId);
}
