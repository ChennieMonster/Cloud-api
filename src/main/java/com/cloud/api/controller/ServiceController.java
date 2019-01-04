package com.cloud.api.controller;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.AppInstanceDTOExample;
import com.cloud.api.dto.AppInstanceDTOExample.Criteria;
import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.ApplicationDTOExample;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.PortsDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.ServiceRequest;
import com.cloud.api.entity.response.ServiceDetailResponse;
import com.cloud.api.entity.response.ServiceResponseData;
import com.cloud.api.mapper.AppInstanceMapper;
import com.cloud.api.mapper.ApplicationMapper;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.ServiceService;
import com.cloud.api.util.CamelToUnderline;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author huang_kefei
 * @date 2018年11月21日 类说明
 */
@Validated
@RestController
@RequestMapping("/services")
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private AppInstanceMapper appInstanceMapper;

	@Autowired
	private ApplicationMapper applicationMapper;

	@Autowired
	private RoleService roleService;

	@GetMapping("")
	@ResponseBody
	public Result<?> getService(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<ServiceRequest> requestBody) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_SERVICES, Constants.ACTION_QUERY);
		// 分页
		long allCount;
		long filterCount;
		List<ServiceResponseData> pageList = null;
		String sortStr = "";
		// 加入project
		String project = requestBody.getProject();
		ServiceRequest dataDO = requestBody.getData();
		List<GetListParamElement> sortList = dataDO.getSort();
//			List<GetListParamElement> filterList = dataDO.getFilter();
		if (sortList != null && !sortList.isEmpty()) {
			for (int i = 0; i < sortList.size(); i++) {
				sortStr += CamelToUnderline.camelToUnderline(sortList.get(i).getKey()) + " "
						+ sortList.get(i).getValue() + ",";
			}
			sortStr = sortStr.substring(0, sortStr.length() - 1);
			PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize(), sortStr);
		} else {
			PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize());
		}
		List<ServiceDTO> dataList = serviceService.queryServiceByProject(project);
//			List<ServiceDTO> dataList = serviceService.filterApplication(filterList, requestBody.getProject());
		List<ServiceResponseData> serviceList = new ArrayList<>();
		if (dataList != null && !dataList.isEmpty()) {
			for (ServiceDTO dto : dataList) {
				ServiceResponseData serivce = new ServiceResponseData();
				serivce.setName(dto.getName());
				serivce.setCreatedTime(dto.getCreatedTime());
				serivce.setUuid(dto.getUuid());

				// instance name
				String instanceId = dto.getInstanceId();
				AppInstanceDTOExample example = new AppInstanceDTOExample();
				Criteria criteria = example.createCriteria();
				criteria.andUuidEqualTo(instanceId);
				List<AppInstanceDTO> instanceList = appInstanceMapper.selectByExample(example);
				String applicationId = "";
				if (instanceList != null && !instanceList.isEmpty()) {
					String instanceName = instanceList.get(0).getDisplayName();
					serivce.setInstanceName(instanceName);
					applicationId = instanceList.get(0).getApplicationId();
				}

				// application name
				ApplicationDTOExample example2 = new ApplicationDTOExample();
				com.cloud.api.dto.ApplicationDTOExample.Criteria criteria2 = example2.createCriteria();
				criteria2.andUuidEqualTo(applicationId);
				List<ApplicationDTO> appList = applicationMapper.selectByExample(example2);
				if (appList != null && !appList.isEmpty()) {
					String appName = appList.get(0).getDisplayName();
					serivce.setApplicationName(appName);
				}
				serviceList.add(serivce);
			}
			PageInfo<ServiceResponseData> page = new PageInfo<ServiceResponseData>(serviceList);
			filterCount = page.getTotal();
			allCount = page.getTotal();
			pageList = page.getList();
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		}
		// list为空
		return ResultGenerator.genFailedResult();
	}

	// service详细
	@GetMapping("/{id}")
	@ResponseBody
	public Result<?> getServiceDetail(@RequestBody GuiRequestBody<ServiceRequest> requestBody,@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_SERVICE, Constants.ACTION_QUERY);
		// 分页
		ServiceDTO serviceDTO = serviceService.queryServiceById(id);
		String instanceId = serviceDTO.getInstanceId();
		AppInstanceDetailDO serviceDO = new AppInstanceDetailDO();
		ServiceDetailResponse serviceResponse = new ServiceDetailResponse();
		if (serviceDTO != null) {
			serviceDO.setMetadata(JsonUtils.jsonToObject(serviceDTO.getMetadata(), MetaDataDO.class));
			serviceDO.setSpec(JsonUtils.jsonToObject(serviceDTO.getSpec(), SpecDO.class));
			List<PortsDO> postsList = serviceDO.getSpec().getPorts();
			// 组装response
			serviceResponse.setIp(serviceDO.getSpec().getClusterIP());
			serviceResponse.setPorts(postsList);
			serviceResponse.setSessionAffinity(serviceDO.getSpec().getSessionAffinity());
			serviceResponse.setType(serviceDO.getSpec().getType());
			serviceResponse.setInstanceId(instanceId);
			serviceResponse.setName(serviceDTO.getName());
			if (serviceDO.getMetadata().getLabels() != null) {
				serviceResponse.setLabels(serviceDO.getMetadata().getLabels().get("app"));
			}
		} else {
			return ResultGenerator.genFailedResult("no found matched service!");
		}
		return ResultGenerator.genGetOkResult(serviceResponse);
	}

}
