/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.DeploymentDTOExample;
import com.cloud.api.dto.PodDTO;
import com.cloud.api.dto.PodDTOExample;
import com.cloud.api.dto.PodDTOExample.Criteria;
import com.cloud.api.dto.ReplicasetDTO;
import com.cloud.api.dto.ReplicasetDTOExample;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.PodDO;
import com.cloud.api.entity.PodSpecDO;
import com.cloud.api.entity.StatusDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.response.PodResponseData;
import com.cloud.api.mapper.DeploymentMapper;
import com.cloud.api.mapper.PodMapper;
import com.cloud.api.mapper.ReplicasetMapper;
import com.cloud.api.service.ContainerService;
import com.cloud.api.service.PodService;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.StringToUTCDate2;
import com.cloud.api.util.annotation.Operation;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PodServiceImpl extends BaseService implements PodService {

	@Resource
	private PodMapper podMapper;

	@Resource
	private ContainerService containerService;

	@Resource
	private ReplicasetMapper replicasetMapper;

	@Resource
	private DeploymentMapper deploymentMapper;

	private final static Logger logger = LoggerFactory.getLogger(PodServiceImpl.class);

	@Override
	@Operation(action = "delete pod", resourceType = "pod")
	public int deletePod(String setId, TokenDO token, String project) {
		// 更新DB
		PodDTOExample example2 = new PodDTOExample();
		Criteria criteria2 = example2.createCriteria();
		criteria2.andSet_idEqualTo(setId);
		return podMapper.deleteByExample(example2);
	}

	@Override
	@Operation(action = "edit pod", resourceType = "pod")
	public int updatePod(PodDO podDO, String podId, String podName, TokenDO token) {
		// TODO Auto-generated method stub
		logger.info("==========updatePod begin, podId = " + podId);
		Invocation<PodDO> invocation = put(PodDO.class, "/api/v1/namespaces/cloud-api-test/pods/" + podName, token)
				.entity(podDO);
		CloseableHttpResponse response = invocation.executeWithResponse();

//		更新DB
		PodDTOExample example = new PodDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andUuidEqualTo(podId);
		PodDTO podDTO = new PodDTO();
		podDTO.setMetaData(JsonUtils.objectToJson(podDO.getMetadata()));
		podDTO.setSpec(JsonUtils.objectToJson(podDO.getSpec()));
		logger.info("==========updatePod end");
		return podMapper.updateByExampleSelective(podDTO, example);
	}

	@Override
	public List<PodResponseData> getPodList(String instanceId) {
		// TODO Auto-generated method stub
		String deploymentId = "";
		String setId = "";
		List<DeploymentDTO> depList = null;
		DeploymentDTOExample exampleDep = new DeploymentDTOExample();
		com.cloud.api.dto.DeploymentDTOExample.Criteria criteriaDep = exampleDep.createCriteria();
		criteriaDep.andInstanceIdEqualTo(instanceId);
		depList = deploymentMapper.selectByExample(exampleDep);
		logger.warn(depList.size() + "depList=======================================+++++++++++++++++++++");
		if (depList != null && !depList.isEmpty()) {
			deploymentId = depList.get(0).getUuid();
			ReplicasetDTOExample exampleSet = new ReplicasetDTOExample();
			com.cloud.api.dto.ReplicasetDTOExample.Criteria criteriaSet = exampleSet.createCriteria();
			criteriaSet.andDeploymentIdEqualTo(deploymentId);
			List<ReplicasetDTO> setList = replicasetMapper.selectByExample(exampleSet);
			if (setList != null && !setList.isEmpty()) {
				logger.warn(setList.size() + "setList=======================================+++++++++++++++++++++");
				setId = setList.get(0).getUuid();
				if (setId != null && !setId.equals("")) {
					PodDTOExample example = new PodDTOExample();
					Criteria criteria = example.createCriteria();
					criteria.andSet_idEqualTo(setId);
//					PodDTO podDTO =new PodDTO();
					List<PodDTO> podList = podMapper.selectByExample(example);
					List<PodResponseData> dataList = new ArrayList<PodResponseData>();
					if (podList != null && !podList.isEmpty()) {
						logger.warn(
								podList.size() + "podList=======================================+++++++++++++++++++++");
						for (int i = 0; i < podList.size(); i++) {
							PodDO podDO = new PodDO();
							PodResponseData data = new PodResponseData();
							PodDTO podDTO = podList.get(i);
							podDO.setMetadata(JsonUtils.jsonToObject(podDTO.getMetaData(), MetaDataDO.class));
							podDO.setSpec(JsonUtils.jsonToObject(podDTO.getSpec(), PodSpecDO.class));
							podDO.setStatus(JsonUtils.jsonToObject(podDTO.getStatus(), StatusDO.class));
							// TODO: handle exception
//								logger.warn("json have problem to object ");
							data.setUuid(podDTO.getUuid());
							data.setName(podDTO.getName());
							if (podDO.getStatus() != null) {
								data.setIp(podDO.getStatus().getHostIP());
							}
							if (podDO.getSpec() != null) {
								data.setNode(podDO.getSpec().getNodeName());
							}
							if (podDO.getStatus() != null) {
								data.setStatus(podDO.getStatus().getPhase());
							}
							//
							if (podDO.getMetadata().getCreationTimestamp() != null) {
								data.setCreatedTime(
										StringToUTCDate2.toDate(podDO.getMetadata().getCreationTimestamp()));
							}
							dataList.add(data);
						}
					}
					return dataList;
				}
			}
		}
		return null;
	}

	@Override
	public long countPod() {
		// TODO Auto-generated method stub
		PodDTOExample example = new PodDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.getAllCriteria();
		return podMapper.countByExample(example);
	}

}
