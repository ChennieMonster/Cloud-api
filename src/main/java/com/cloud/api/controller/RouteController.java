package com.cloud.api.controller;

import java.util.ArrayList;

import java.util.List;

import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.AppInstanceDTOExample;
import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.dto.ApplicationDTOExample;
import com.cloud.api.dto.RouteDTO;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.dto.AppInstanceDTOExample.Criteria;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.PortsDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ApplicationRequest;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.RouteRequest;
import com.cloud.api.entity.response.RouteDetailResponse;
import com.cloud.api.entity.response.RouteResponseData;
import com.cloud.api.mapper.AppInstanceMapper;
import com.cloud.api.mapper.ApplicationMapper;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.RouteService;
import com.cloud.api.util.CamelToUnderline;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.Constant;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author huang_kefei
 * @date 2018年11月21日 类说明
 */
@Validated
@RestController
@RequestMapping("/routes")
public class RouteController {

	@Autowired
	private RouteService routeService;

	@Autowired
	private ApplicationMapper applicationMapper;

	@Autowired
	private AppInstanceMapper appInstanceMapper;

	@Autowired
	private RoleService roleService;

	@GetMapping("")
	@ResponseBody
	public Result<?> getRoute(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<RouteRequest> requestBody) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(),requestBody.getProject(),Constants.MODULES_ROUTES, Constants.ACTION_QUERY);
		// 分页
		long allCount;
		long filterCount;
		List<RouteResponseData> pageList = null;
		String sortStr = "";
		// 加入project
		String project = requestBody.getProject();
		RouteRequest dataDO = requestBody.getData();
		List<GetListParamElement> sortList = dataDO.getSort();
//		List<GetListParamElement> filterList = dataDO.getFilter();
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
		List<RouteDTO> dataList = routeService.queryRouteByProject(project);
//		List<ServiceDTO> dataList = serviceService.filterApplication(filterList, requestBody.getProject());
		List<RouteResponseData> routeList = new ArrayList<>();
		if (dataList != null && !dataList.isEmpty()) {
			for (RouteDTO dto : dataList) {
				RouteResponseData route = new RouteResponseData();
				route.setName(dto.getName());
				route.setCreatedTime(dto.getCreatedTime());
				route.setUuid(dto.getUuid());

				// instance name
				String instanceId = dto.getInstanceId();
				AppInstanceDTOExample example = new AppInstanceDTOExample();
				Criteria criteria = example.createCriteria();
				criteria.andUuidEqualTo(instanceId);
				List<AppInstanceDTO> instanceList = appInstanceMapper.selectByExample(example);
				String applicationId = "";
				if (instanceList != null && !instanceList.isEmpty()) {
					String instanceName = instanceList.get(0).getDisplayName();
					route.setInstanceName(instanceName);
					applicationId = instanceList.get(0).getApplicationId();
				}

				// application name
				ApplicationDTOExample example2 = new ApplicationDTOExample();
				com.cloud.api.dto.ApplicationDTOExample.Criteria criteria2 = example2.createCriteria();
				criteria2.andUuidEqualTo(applicationId);
				List<ApplicationDTO> appList = applicationMapper.selectByExample(example2);
				if (appList != null && !appList.isEmpty()) {
					String appName = appList.get(0).getDisplayName();
					route.setApplicationName(appName);
				}
				routeList.add(route);
			}
			PageInfo<RouteResponseData> page = new PageInfo<RouteResponseData>(routeList);
			filterCount = page.getTotal();
			allCount = page.getTotal();
			pageList = page.getList();
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		}

		// list为空
		return ResultGenerator.genFailedResult();
	}

	// route详细
	@GetMapping("/{id}")
	@ResponseBody
	public Result<?> getRouteDetail(@RequestBody GuiRequestBody<RouteRequest> requestBody,@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(),requestBody.getProject(),Constants.MODULES_ROUTE, Constants.ACTION_QUERY);
		// 分页
		RouteDTO routeDTO = routeService.queryRouteById(id);
		AppInstanceDetailDO routeDO = new AppInstanceDetailDO();
		RouteDetailResponse routeResponse = new RouteDetailResponse();
		if (routeDTO != null) {
			routeDO.setMetadata(JsonUtils.jsonToObject(routeDTO.getMetadata(), MetaDataDO.class));
			routeDO.setSpec(JsonUtils.jsonToObject(routeDTO.getSpec(), SpecDO.class));
			routeResponse.setHost(routeDO.getSpec().getHost());
			routeResponse.setName(routeDTO.getName());
			if (routeDO.getSpec().getTo() != null) {
				if ("Service".equals(routeDO.getSpec().getTo().getKind())) {
					routeResponse.setServiceName(routeDO.getSpec().getTo().getName());
					routeResponse.setServiceWeight(routeDO.getSpec().getTo().getWeight());
				}
			}
			if(routeDO.getMetadata().getLabels()!=null) {
				routeResponse.setLabels(routeDO.getMetadata().getLabels().get("app"));
			}
		} else {
			ResultGenerator.genFailedResult("no found matched route!");
		}
		return ResultGenerator.genGetOkResult(routeResponse);
	}
}
