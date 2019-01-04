/**
 * 
 */
package com.cloud.api.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.LabelDTO;
import com.cloud.api.dto.LabelDTOExample;
import com.cloud.api.dto.NodeDTO;
import com.cloud.api.dto.NodeDTOExample;
import com.cloud.api.dto.NodeDTOExample.Criteria;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.LabelPostRequest;
import com.cloud.api.entity.request.LabelRequest;
import com.cloud.api.entity.response.NodeResponse;
import com.cloud.api.mapper.LabelMapper;
import com.cloud.api.mapper.NodeMapper;
import com.cloud.api.service.MonitorService;
import com.cloud.api.service.NodeService;
import com.cloud.api.util.IdGen;

/**
 * @author zhao_pengchen
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NodeServiceImpl extends BaseService implements NodeService {

	@Resource
	private MonitorService monitorService;
	
	@Resource
	private NodeMapper nodeMapper;
	
	@Resource
	private LabelMapper labelMapper;
	
	@Override
	public List<NodeDTO> getNodeList(String regionId) {
		NodeDTOExample example = new NodeDTOExample();
		Criteria criteria = example.createCriteria();
		criteria.andRegionIdEqualTo(regionId);
		List<NodeDTO> nodeList = nodeMapper.selectByExample(example);
		return nodeList;
	}

	@Override
	public NodeResponse getNodeDetail(String nodeId) {
		NodeResponse nodeRes = new NodeResponse();
		NodeDTO nodeDto = nodeMapper.selectByPrimaryKey(nodeId);
		
		LabelDTOExample example = new LabelDTOExample();
		com.cloud.api.dto.LabelDTOExample.Criteria criteria = example.createCriteria();
		criteria.andNodeIdEqualTo(nodeDto.getUuid());
		List<LabelDTO> labelList = labelMapper.selectByExample(example);
		
		nodeRes.setName(nodeDto.getName());
		nodeRes.setCreatedtime(nodeDto.getCreatedtime());
		nodeRes.setInternalIp(nodeDto.getInternalIp());
		nodeRes.setPodsNo(nodeDto.getPodsNo());
		
		Map<String, String> labels = new HashMap<String, String>();
		for(LabelDTO label : labelList) {
			labels.put(label.getLabelKey(), label.getLabelValue());
		}
		nodeRes.setLabels(labels);
		
		nodeRes.setMonitorPhysicalNodesDTO(monitorService.getMonitorDetail(nodeId));
		
		return nodeRes;
	}

	@Override
	public void updateLabels(LabelRequest request, TokenDO token) {
		
		NodeDTO node = nodeMapper.selectByPrimaryKey(request.getNodeId());
		
		//编辑label的处理方法，先全部删除，再全部添加
		LabelDTOExample example = new LabelDTOExample();
		com.cloud.api.dto.LabelDTOExample.Criteria criteria = example.createCriteria();
		criteria.andNodeIdEqualTo(request.getNodeId());
		List<LabelDTO> labelList = labelMapper.selectByExample(example);
		Map<String, String> labelsForDel = new HashMap<>();
		for(LabelDTO label : labelList) {
			labelsForDel.put(label.getLabelKey(), null);
		}
		
		//全部删除
		LabelDTOExample exampleForDel = new LabelDTOExample();
		labelMapper.deleteByExample(exampleForDel);
		
		LabelPostRequest postRequestForDel = new LabelPostRequest();
		MetaDataDO metadataForDel = new MetaDataDO();
		metadataForDel.setLabels(labelsForDel);
		postRequestForDel.setMetadata(metadataForDel);
		
		Invocation<LabelPostRequest> invocation_p = patch(LabelPostRequest.class,
				"/api/v1/nodes/"+node.getName(), token).entity(postRequestForDel).contentType("application/strategic-merge-patch+json");
		invocation_p.executeWithResponse();
		
		//全部添加
		for (Entry<String, String> entry : request.getLabels().entrySet()) {
			if(entry.getKey()==null || entry.getKey()==""
					||entry.getValue()==null || entry.getValue()=="") {
				throw new ServiceException("Labels key or value can't be null");
			}
						
			LabelDTO label = new LabelDTO();
			label.setLabelValue(entry.getValue());
			label.setLabelKey(entry.getKey());
			label.setUuid(IdGen.uuid());
			label.setNodeId(request.getNodeId());
			labelMapper.insertSelective(label);
			
		}
		
		LabelPostRequest postRequest = new LabelPostRequest();
		MetaDataDO metadata = new MetaDataDO();
		metadata.setLabels(request.getLabels());
		postRequest.setMetadata(metadata);
		
		Invocation<LabelPostRequest> invocation_p2 = patch(LabelPostRequest.class,
				"/api/v1/nodes/"+node.getName(), token).entity(postRequest).contentType("application/strategic-merge-patch+json");
		invocation_p2.executeWithResponse();
	}

}
