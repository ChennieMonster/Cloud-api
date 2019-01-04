package com.cloud.api.service;



import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;

/**
 * @author huang_kefei
 * @date 2018年9月28日 类说明
 */
public interface ReplicasetService {

	int deleteSet(String deploymentId,String setName,TokenDO token,String project);

	int updateSet(SpecDO setDO,String deploymentId,String setName,TokenDO token);
}
