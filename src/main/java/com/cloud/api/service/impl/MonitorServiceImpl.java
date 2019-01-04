package com.cloud.api.service.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.MonitorAlarmDTO;
import com.cloud.api.dto.MonitorAlarmDTOExample;
import com.cloud.api.dto.MonitorBlockIoDTO;
import com.cloud.api.dto.MonitorContainerDTO;
import com.cloud.api.dto.MonitorContainerDTOExample;
import com.cloud.api.dto.MonitorDiskIoDTO;
import com.cloud.api.dto.MonitorDiskIoDTOExample;
import com.cloud.api.dto.MonitorHistoryDTO;
import com.cloud.api.dto.MonitorNetworkDTO;
import com.cloud.api.dto.MonitorObjAlarmDTO;
import com.cloud.api.dto.MonitorObjAlarmDTOExample;
import com.cloud.api.dto.MonitorPhysicalNodesDTO;
import com.cloud.api.dto.MonitorPhysicalNodesDTOExample;
import com.cloud.api.dto.MonitorRuleAlarmDTO;
import com.cloud.api.dto.MonitorRuleAlarmDTOExample;
import com.cloud.api.dto.MonitorRuleInstanceDTO;
import com.cloud.api.dto.MonitorRuleInstanceDTOExample;
import com.cloud.api.dto.NodeDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.request.ExportMonitorRequest;
import com.cloud.api.entity.request.MonitorRuleRequestData;
import com.cloud.api.entity.response.ApplicationMonitorResponse;
import com.cloud.api.entity.response.ContainerMonitorResponse;
import com.cloud.api.entity.response.MonitorAlarmApplyResponse;
import com.cloud.api.entity.response.NodeMonitorResponse;
import com.cloud.api.mapper.ApplicationMapper;
import com.cloud.api.mapper.ContainerMapper;
import com.cloud.api.mapper.MonitorAlarmMapper;
import com.cloud.api.mapper.MonitorBlockIoMapper;
import com.cloud.api.mapper.MonitorContainerMapper;
import com.cloud.api.mapper.MonitorDiskIoMapper;
import com.cloud.api.mapper.MonitorHistoryMapper;
import com.cloud.api.mapper.MonitorNetworkMapper;
import com.cloud.api.mapper.MonitorObjAlarmMapper;
import com.cloud.api.mapper.MonitorPhysicalNodesMapper;
import com.cloud.api.mapper.MonitorRuleAlarmMapper;
import com.cloud.api.mapper.MonitorRuleInstanceMapper;
import com.cloud.api.mapper.NodeMapper;
import com.cloud.api.mapper.ResourcesMapper;
import com.cloud.api.service.MonitorService;
import com.cloud.api.util.ExportExcelUtil;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.MessageUtils;

@Service
@Transactional(rollbackFor=Exception.class)
public class MonitorServiceImpl implements MonitorService {
	
	@Resource
	private MonitorPhysicalNodesMapper physicalNodesMapper;
	
	@Resource
	private MonitorDiskIoMapper diskIoMapper;
	
	@Resource
	private MonitorNetworkMapper networkMapper;
	
	@Resource
	private MonitorHistoryMapper historyMapper;
	
	@Resource
	private MonitorAlarmMapper monitorAlarmMapper;
	
	@Resource
	private MonitorRuleAlarmMapper monitorRuleAlarmMapper;
	
	@Resource
	private MonitorObjAlarmMapper monitorObjAlarmMapper;
	
	@Resource
	private MonitorRuleInstanceMapper monitorRuleInstanceMapper;
	
	@Resource
	private ResourcesMapper resourcesMapper;
	
	@Resource
	private MonitorContainerMapper monitorContainerMapper;
	
	@Resource
	private MonitorBlockIoMapper monitorBlockIoMapper;
	
	@Resource
	private NodeMapper nodeMapper;
	
	@Resource
	private ApplicationMapper applicationMapper;
	
	@Resource
	private ContainerMapper containerMapper;
	
	@Override
	public NodeMonitorResponse queryMoniorHostByNodeId(Map<String,Object> queryParam) {
		String nodeId = (String) queryParam.get("monitorObjId");
		int period = (int) queryParam.get("period");
		int duration = (int) queryParam.get("duration");
		
		NodeMonitorResponse response = new NodeMonitorResponse();
		
		MonitorPhysicalNodesDTO physicalNodesDTO = physicalNodesMapper.selectByPrimaryKey(nodeId);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monitorObjId", nodeId);
		param.put("duration", duration);
		param.put("period", period);
		List<MonitorNetworkDTO> repNetList = networkMapper.selectMonitorGroupByTime(param);
		
		List<MonitorDiskIoDTO> repDiskIoList = diskIoMapper.selectMonitorDisoIOGroupByTime(param);
		
		param.put("dataType", "cpu_util");
		List<MonitorHistoryDTO> cpuUtilList = historyMapper.selectMonitorHistoryGroupByTime(param);
		
		param.put("dataType", "memory_util");
		List<MonitorHistoryDTO> memoryUtilList = historyMapper.selectMonitorHistoryGroupByTime(param);
		
		response.setPhysicalNodesDTO(physicalNodesDTO);
		response.setIoList(repDiskIoList);
		response.setNetList(repNetList);
		response.setCpuUtilList(cpuUtilList);
		response.setMemoryUtilList(memoryUtilList);
		
		return response;
		
	}

	@Override
	public void addMonitorAlarm(MonitorRuleRequestData requestData) {
		MonitorAlarmDTO monitorAlarmDTO = requestData.getMonitorAlarm();
		List<MonitorRuleAlarmDTO> ruleList = requestData.getRules();
		String monitorAlarmId = IdGen.uuid();
		monitorAlarmDTO.setUuid(monitorAlarmId);
		monitorAlarmMapper.insertSelective(monitorAlarmDTO);
		for (MonitorRuleAlarmDTO monitorRuleAlarmDTO : ruleList) {
			monitorRuleAlarmDTO.setUuid(IdGen.uuid());
			monitorRuleAlarmDTO.setMonitorAlarmId(monitorAlarmId);
			monitorRuleAlarmDTO.setNotifications(JsonUtils.objectToJson(monitorRuleAlarmDTO.getNotification()));
			monitorRuleAlarmMapper.insertSelective(monitorRuleAlarmDTO);
		}
	}

	@Override
	public void editMonitorAlarmRule(MonitorRuleRequestData requestData) {
		// 
		
	}

	@Override
	public List<MonitorPhysicalNodesDTO> getAllHostMonitors() {
		List<MonitorPhysicalNodesDTO> monitorList = physicalNodesMapper.selectAllMonitorPhysicalNodes();
		return monitorList;
	}

	@Override
	public MonitorPhysicalNodesDTO getMonitorDetail(String nodeId) {
		MonitorPhysicalNodesDTOExample example = new MonitorPhysicalNodesDTOExample();
		MonitorPhysicalNodesDTOExample.Criteria criteria = example.createCriteria();
		criteria.andNodeIdEqualTo(nodeId);
		List<MonitorPhysicalNodesDTO> monitorList = physicalNodesMapper.selectByExample(example);
		
		MonitorDiskIoDTOExample diskIoDTOExample = new MonitorDiskIoDTOExample();
		MonitorDiskIoDTOExample.Criteria diskIoCriteria = diskIoDTOExample.createCriteria();
		diskIoCriteria.andMonitorObjIdEqualTo(nodeId);
		diskIoCriteria.andClockBetween((int)(System.currentTimeMillis()/1000 - 3600), (int)(System.currentTimeMillis()/1000));
		diskIoDTOExample.setOrderByClause("clock desc");
		List<MonitorDiskIoDTO> diskIoList = diskIoMapper.selectByExample(diskIoDTOExample);
		Map<String,Map<String, Float>> diskIoMap = new HashMap<String, Map<String,Float>>();
		for (MonitorDiskIoDTO monitorDiskIoDTO : diskIoList) {
			String diskName = monitorDiskIoDTO.getDiskName();
			if(diskIoMap.get(diskName) == null) {
				Map<String,Float> map = new HashMap<String,Float>();
				diskIoMap.put(diskName, map);
				map.put("wps", monitorDiskIoDTO.getWps());
				map.put("rps", monitorDiskIoDTO.getRps());
			}else {
				break;
			}
		}
		if(monitorList.size() > 0) {
			MonitorPhysicalNodesDTO nodesDTO = monitorList.get(0);
			nodesDTO.setDiskIo(diskIoMap);
			return nodesDTO;
		}
		
		return null;
	}

	@Override
	public void applyMonitorAlarm(String monitorAlarmId, String monitorObjId) {
		MonitorObjAlarmDTO monitorObjAlarmDTO = new MonitorObjAlarmDTO();
		String monitorObjAlarmId = IdGen.uuid();
		monitorObjAlarmDTO.setUuid(monitorObjAlarmId);
		monitorObjAlarmDTO.setMonitorObjId(monitorObjId);
		monitorObjAlarmDTO.setMonitorAlarmId(monitorAlarmId);
		monitorObjAlarmDTO.setStatus("enable");
		monitorObjAlarmMapper.insertSelective(monitorObjAlarmDTO);
		
		MonitorRuleAlarmDTOExample ruleAlarmDTOExample = new MonitorRuleAlarmDTOExample();
		MonitorRuleAlarmDTOExample.Criteria criteria = ruleAlarmDTOExample.createCriteria();
		criteria.andMonitorAlarmIdEqualTo(monitorAlarmId);
		List<MonitorRuleAlarmDTO> ruleAlarmDTOs = monitorRuleAlarmMapper.selectByExample(ruleAlarmDTOExample);
		for (MonitorRuleAlarmDTO monitorRuleAlarmDTO : ruleAlarmDTOs) {
			MonitorRuleInstanceDTO ruleInstanceDTO = new MonitorRuleInstanceDTO();
			ruleInstanceDTO.setUuid(IdGen.uuid());
			ruleInstanceDTO.setAction(monitorRuleAlarmDTO.getAction());
			ruleInstanceDTO.setItem(monitorRuleAlarmDTO.getItem());
			ruleInstanceDTO.setMonitorObjAlarmId(monitorObjAlarmId);
			ruleInstanceDTO.setPeriod(monitorRuleAlarmDTO.getPeriod());
			ruleInstanceDTO.setThreshold(monitorRuleAlarmDTO.getThreshold());
			ruleInstanceDTO.setType(monitorRuleAlarmDTO.getType());
			if(monitorRuleAlarmDTO.getItem().contains("cpu") || monitorRuleAlarmDTO.getItem().contains("memory")) {
				ruleInstanceDTO.setUnit("%");
			}else if(monitorRuleAlarmDTO.getItem().contains("net") || monitorRuleAlarmDTO.getItem().contains("block")) {
				ruleInstanceDTO.setUnit("m");
			}
			ruleInstanceDTO.setNotifications(monitorRuleAlarmDTO.getNotifications());
			monitorRuleInstanceMapper.insertSelective(ruleInstanceDTO);
		}
	}

	@Override
	public List<MonitorAlarmDTO> queryAllMonitorAlarm() {
		List<MonitorAlarmDTO> list = monitorAlarmMapper.selectAllMonitorAlarm();
		return list;
	}

	@Override
	public MonitorRuleRequestData queryMonitorAlarmById(String monitorAlarmId) {
		MonitorAlarmDTO monitorAlarmDTO = monitorAlarmMapper.selectByPrimaryKey(monitorAlarmId);
		MonitorRuleAlarmDTOExample ruleAlarmDTOExample = new MonitorRuleAlarmDTOExample();
		MonitorRuleAlarmDTOExample.Criteria criteria = ruleAlarmDTOExample.createCriteria();
		criteria.andMonitorAlarmIdEqualTo(monitorAlarmId);
		List<MonitorRuleAlarmDTO> ruleAlarmDTOs = monitorRuleAlarmMapper.selectByExample(ruleAlarmDTOExample);
		for (MonitorRuleAlarmDTO monitorRuleAlarmDTO : ruleAlarmDTOs) {
			if(monitorRuleAlarmDTO.getNotifications() != null) {
				monitorRuleAlarmDTO.setNotification(JsonUtils.jsonToObject(monitorRuleAlarmDTO.getNotifications(), List.class, String.class));
				monitorRuleAlarmDTO.setNotifications(null);
			}
		}
		MonitorRuleRequestData reponse = new MonitorRuleRequestData();
		reponse.setMonitorAlarm(monitorAlarmDTO);
		reponse.setRules(ruleAlarmDTOs);
		return reponse;
	}
	
	@Override
	public ContainerMonitorResponse queryMonitorContainer(Map<String,Object> queryParam) {
		String containerId = (String) queryParam.get("monitorObjId");
		int period = (int) queryParam.get("period");
		int duration = (int) queryParam.get("duration");
		
		ContainerMonitorResponse response = new ContainerMonitorResponse();
		
		MonitorContainerDTO monitorContainer = monitorContainerMapper.selectByPrimaryKey(containerId);
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monitorObjId", containerId);
		param.put("duration", duration);
		param.put("period", period);
		List<MonitorNetworkDTO> repNetList = networkMapper.selectMonitorGroupByTime(param);
		
		List<MonitorBlockIoDTO> repBlockIoList = monitorBlockIoMapper.selectMonitorBlockIOGroupByTime(param);
		
		param.put("dataType", "cpu_util");
		List<MonitorHistoryDTO> cpuUtilList = historyMapper.selectMonitorHistoryGroupByTime(param);
		
		param.put("dataType", "memory_util");
		List<MonitorHistoryDTO> memoryUtilList = historyMapper.selectMonitorHistoryGroupByTime(param);
		
		response.setMonitorContainer(monitorContainer);
		response.setIoList(repBlockIoList);
		response.setNetList(repNetList);
		response.setCpuUtilList(cpuUtilList);
		response.setMemoryUtilList(memoryUtilList);
		
		return response;
		
	}
	
	@Override
	public ApplicationMonitorResponse queryMonitorApplicationLatest(String applicationId) {
		
		List<String> conIdList = containerMapper.selectContainersByApplicationId(applicationId);
		MonitorContainerDTOExample monitorContainerDTOExample = new MonitorContainerDTOExample();
		MonitorContainerDTOExample.Criteria monitorContainerCriteria = monitorContainerDTOExample.createCriteria();
		monitorContainerCriteria.andConCloudIdIn(conIdList);
		List<MonitorContainerDTO> monitorContainerList = monitorContainerMapper.selectByExample(monitorContainerDTOExample);
		
		float cpuUtil = 0;
		long memoryTotal = 0;
		long memoryUsage = 0;
		long netIn = 0;
		long netOut = 0;
		long blockIn = 0;
		long blockOut = 0;
		for (MonitorContainerDTO monitorContainerDTO : monitorContainerList) {
			cpuUtil += monitorContainerDTO.getCpuUtil();
			memoryTotal += monitorContainerDTO.getMemory();
			memoryUsage += monitorContainerDTO.getMemoryUsage();
			netIn += monitorContainerDTO.getNetIn();
			netOut += monitorContainerDTO.getNetOut();
			blockIn += monitorContainerDTO.getBlockIn();
			blockOut += monitorContainerDTO.getBlockOut();
		}
		DecimalFormat df  = new DecimalFormat("0.00");
		if(monitorContainerList.size() != 0) {
			cpuUtil = Float.valueOf(df.format((float)cpuUtil/monitorContainerList.size()));
		}
		ApplicationMonitorResponse response = new ApplicationMonitorResponse(cpuUtil, memoryTotal, memoryUsage, netIn, netOut, blockIn, blockOut);
		return response;
		
	}
	
	@Override
	public List<MonitorAlarmApplyResponse> getMonitorAlarmApplyObj(List<GetListParamElement> filterList) {
		List<MonitorAlarmApplyResponse> responseList = new ArrayList<MonitorAlarmApplyResponse>();
		
		MonitorObjAlarmDTOExample objAlarmDTOExample = new MonitorObjAlarmDTOExample();
		MonitorObjAlarmDTOExample.Criteria objAlarmCriteria = objAlarmDTOExample.createCriteria();
		if (filterList != null && !filterList.isEmpty()) {
			for (GetListParamElement getListParamElement : filterList) {
				String key = getListParamElement.getKey();
				switch(key) {
				case "monitorAlarmId":
					objAlarmCriteria.andMonitorAlarmIdEqualTo(getListParamElement.getValue());
				}
			}
		}
		List<MonitorObjAlarmDTO> objAlarmList = monitorObjAlarmMapper.selectByExample(objAlarmDTOExample);
		
		for (MonitorObjAlarmDTO monitorObjAlarmDTO : objAlarmList) {
			
			MonitorAlarmDTO monitorAlarm = monitorAlarmMapper.selectByPrimaryKey(monitorObjAlarmDTO.getMonitorAlarmId());
			String monitorAlarmId = monitorObjAlarmDTO.getMonitorAlarmId();
			
			MonitorAlarmApplyResponse response = new MonitorAlarmApplyResponse();
			
			String type = monitorAlarm.getType();
			if(Constants.MONITOR_TYPE_HOST.equals(type)) {
				NodeDTO node = nodeMapper.selectByPrimaryKey(monitorObjAlarmDTO.getMonitorObjId());
				response.setDescription("");
				response.setDisplayName("");
				response.setMonitorAlarmId(monitorAlarmId);
				response.setMonitorObjId(node.getUuid());
				response.setName(node.getName());
			}else if(Constants.MONITOR_TYPE_APPLICATION.equals(type)) {
				ApplicationDTO application = applicationMapper.queryApplicationByUuid(monitorObjAlarmDTO.getMonitorObjId());
				response.setDescription(application.getDescription());
				response.setDisplayName(application.getDisplayName());
				response.setMonitorAlarmId(monitorAlarmId);
				response.setMonitorObjId(application.getUuid());
				response.setName(application.getName());
			}
			responseList.add(response);
		}
		
		return responseList;
	}

	@Override
	public void deleteMonitorAlarms(List<String> ids) {
		if(ids != null && ids.size() > 0) {
			for (String id : ids) {
				MonitorObjAlarmDTOExample example = new MonitorObjAlarmDTOExample();
				MonitorObjAlarmDTOExample.Criteria objAlarmCriteria = example.createCriteria();
				objAlarmCriteria.andMonitorAlarmIdEqualTo(id);
				List<MonitorObjAlarmDTO> monitorObjAlarms = monitorObjAlarmMapper.selectByExample(example);
				if(monitorObjAlarms != null && monitorObjAlarms.size() > 0) {
					throw new ParamInvalidException(MessageUtils.getMessage("monitorAlarm.is.applied"));
				}
			}
			
			MonitorAlarmDTOExample alarmDTOExample = new MonitorAlarmDTOExample();
			MonitorAlarmDTOExample.Criteria alarmCriteria = alarmDTOExample.createCriteria();
			alarmCriteria.andUuidIn(ids);
			monitorAlarmMapper.deleteByExample(alarmDTOExample);
		}
	}
	
	@Override
	public void cancelApplyMonitorAlarm(List<String> ids) {
		if(ids != null && ids.size() > 0) {
			for (String id : ids) {
				MonitorObjAlarmDTOExample example = new MonitorObjAlarmDTOExample();
				MonitorObjAlarmDTOExample.Criteria objAlarmCriteria = example.createCriteria();
				objAlarmCriteria.andMonitorObjIdEqualTo(id);
				List<MonitorObjAlarmDTO> monitorObjAlarms = monitorObjAlarmMapper.selectByExample(example);
				if(monitorObjAlarms != null && monitorObjAlarms.size() > 0) {
					MonitorObjAlarmDTO monitorObjAlarmDTO = monitorObjAlarms.get(0);
					MonitorRuleInstanceDTOExample ruleInstanceDTOExample = new MonitorRuleInstanceDTOExample();
					MonitorRuleInstanceDTOExample.Criteria ruleInstanceCriteria = ruleInstanceDTOExample.createCriteria();
					ruleInstanceCriteria.andMonitorObjAlarmIdEqualTo(monitorObjAlarmDTO.getUuid());
					monitorRuleInstanceMapper.deleteByExample(ruleInstanceDTOExample);
				}
				monitorObjAlarmMapper.deleteByExample(example);
			}
		}
	}
	
	@Override
	public ContainerMonitorResponse queryMonitorApplicationList(Map<String, Object> queryParam) {
		String applicationId = (String) queryParam.get("monitorObjId");
		int period = (int) queryParam.get("period");
		int duration = (int) queryParam.get("duration");
		List<String> conIdList = containerMapper.selectContainersByApplicationId(applicationId);
		ContainerMonitorResponse response = new ContainerMonitorResponse();
		if(conIdList == null || conIdList.size() == 0) {
			response.setIoList(new ArrayList<MonitorBlockIoDTO>());
			response.setNetList(new ArrayList<MonitorNetworkDTO>());
			response.setCpuUtilList(new ArrayList<MonitorHistoryDTO>());
			response.setMemoryUtilList(new ArrayList<MonitorHistoryDTO>());
			return response;
		}
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monitorObjId", applicationId);
		param.put("duration", duration);
		param.put("period", period);
		param.put("conIdList", conIdList);
		List<MonitorNetworkDTO> repNetList = networkMapper.selectAppMonitorGroupByTime(param);
		
		List<MonitorBlockIoDTO> repBlockIoList = monitorBlockIoMapper.selectAppMonitorBlockIOGroupByTime(param);
		
		param.put("dataType", "cpu_util");
		List<MonitorHistoryDTO> cpuUtilList = historyMapper.selectAppMonitorHistoryGroupByTime(param);
		
		param.put("dataType", "memory_util");
		List<MonitorHistoryDTO> memoryUtilList = historyMapper.selectAppMonitorHistoryGroupByTime(param);
		
		response.setIoList(repBlockIoList);
		response.setNetList(repNetList);
		response.setCpuUtilList(cpuUtilList);
		response.setMemoryUtilList(memoryUtilList);
		return response;
	}
	
	@Override
	public HSSFWorkbook exportMonitorData(ExportMonitorRequest request) {
		List<String> items = request.getItems();
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("monitorObjId", request.getMonitorObjId());
		param.put("period", request.getPeriod());
		param.put("startTime", request.getStartTime());
		param.put("endTime", request.getEndTime());
		HSSFWorkbook hwb = new HSSFWorkbook();
		for (String item : items) {
			switch (item){
			case Constants.ITEM_CPU_UTIL:
				param.put("dataType", "cpu_util");
				List<MonitorHistoryDTO> cpuUtilList = historyMapper.selectMonitorHistoryGroupByTime(param);
				List<String> cpuCellList = new ArrayList<String>();
				cpuCellList.add("time");
				cpuCellList.add("value");
				hwb = ExportExcelUtil.exportExcel(hwb, cpuUtilList, item, cpuCellList);
				break;
			case Constants.ITEM_MEMORY_UTIL:
				param.put("dataType", "memory_util");
				List<MonitorHistoryDTO> memoryUtilList = historyMapper.selectMonitorHistoryGroupByTime(param);
				List<String> memoryCellList = new ArrayList<String>();
				memoryCellList.add("time");
				memoryCellList.add("value");
				hwb = ExportExcelUtil.exportExcel(hwb, memoryUtilList, item, memoryCellList);
				break;
			case Constants.ITEM_NET:
				List<MonitorNetworkDTO> repNetList = networkMapper.selectMonitorGroupByTime(param);
				List<String> netCellList = new ArrayList<String>();
				netCellList.add("time");
				netCellList.add("netIn");
				netCellList.add("netOut");
				hwb = ExportExcelUtil.exportExcel(hwb, repNetList, item, netCellList);
				break;
			case Constants.ITEM_DISK:
				List<MonitorDiskIoDTO> repDiskIoList = diskIoMapper.selectMonitorDisoIOGroupByTime(param);
				List<String> diskCellList = new ArrayList<String>();
				diskCellList.add("time");
				diskCellList.add("diskName");
				diskCellList.add("wps");
				diskCellList.add("rps");
				hwb = ExportExcelUtil.exportExcel(hwb, repDiskIoList, item, diskCellList);
				break;
			case Constants.ITEM_BLOCK:
				List<MonitorBlockIoDTO> repBlockIoList = monitorBlockIoMapper.selectMonitorBlockIOGroupByTime(param);
				List<String> blockCellList = new ArrayList<String>();
				blockCellList.add("time");
				blockCellList.add("blockIn");
				blockCellList.add("blockOut");
				hwb = ExportExcelUtil.exportExcel(hwb, repBlockIoList, item, blockCellList);
				break;
			}
		}
		return hwb;
	}

}
