package com.cloud.api.service.impl;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.exception.ResourcesNotFoundException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.ReplicasetDTO;
import com.cloud.api.dto.ReplicasetDTOExample;
import com.cloud.api.dto.ReplicasetDTOExample.Criteria;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.mapper.ReplicasetMapper;
import com.cloud.api.service.ReplicasetService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.Operation;

/**
 * @author huang_kefei
 * @date 2018年9月28日 类说明
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class ReplicasetServiceImpl extends BaseService implements ReplicasetService {

	private final static Logger logger = LoggerFactory.getLogger(TemplateServiceImpl.class);

	@Resource
	private ReplicasetMapper replicasetMapper;

	@Override
	@Operation(action = "delete set", resourceType = "set")
	public int deleteSet(String deploymentId, String setName, TokenDO token, String project) {
		// TODO Auto-generated method stub
		logger.warn("==========进入delete DB Set");
		// db
		ReplicasetDTOExample example = new ReplicasetDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeploymentIdEqualTo(deploymentId);
		replicasetMapper.deleteByExample(example);
		/*
		 * //openshift try { Invocation<SpecDO> invocation = delete(SpecDO.class,
		 * "/apis/extensions/v1beta1/namespaces/"+project+"/replicasets/" + setName,
		 * token); CloseableHttpResponse response = invocation.executeWithResponse();
		 * logger.
		 * warn("openshift deleteSet================================+++++++++++++++++++++++++++++++++"
		 * ); } catch (ResourcesNotFoundException e) { // TODO: handle exception
		 * logger.warn("openshift resourse 404"); }
		 */
		return 1;
	}

	@Override
	@Operation(action = "edit set", resourceType = "set")
	public int updateSet(SpecDO setDO, String deploymentId, String setName, TokenDO token) {
		// TODO Auto-generated method stub
		logger.warn("==========进入updateSet");

		Invocation<SpecDO> invocation = put(SpecDO.class,
				"/apis/extensions/v1beta1/namespaces/cloud-api-test/replicasets/" + setName, token).entity(setDO);
		CloseableHttpResponse response = invocation.executeWithResponse();

		ReplicasetDTO replicasetDTO = new ReplicasetDTO();
		replicasetDTO.setSelector(JsonUtils.objectToJson(setDO.getSelector()));
		replicasetDTO.setStrategy(JsonUtils.objectToJson(setDO.getSelector()));
		replicasetDTO.setProgressDeadlineSeconds(setDO.getProgressDeadlineSeconds());
		replicasetDTO.setRevisionHistoryLimit(setDO.getRevisionHistoryLimit());
		replicasetDTO.setReplicas(setDO.getReplicas());
//		setDO.setTemplate(podDO);
		replicasetDTO.setTemplate(JsonUtils.objectToJson(setDO));

		ReplicasetDTOExample example = new ReplicasetDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andDeploymentIdEqualTo(deploymentId);
		return replicasetMapper.updateByExampleSelective(replicasetDTO, example);
	}

}
