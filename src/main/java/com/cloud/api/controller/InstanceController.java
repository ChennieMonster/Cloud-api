/**
 * 
 */
package com.cloud.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.exception.ParamInvalidException;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.DeploymentDTOExample;
import com.cloud.api.dto.RouteDTO;
import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.PortsDO;
import com.cloud.api.entity.SpecDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.InstanceRequest;
import com.cloud.api.entity.request.PodRequest;
import com.cloud.api.entity.response.PodResponseData;
import com.cloud.api.entity.response.RouteDetailResponse;
import com.cloud.api.entity.response.ServiceDetailResponse;
import com.cloud.api.mapper.DeploymentMapper;
import com.cloud.api.service.AppInstanceService;
import com.cloud.api.service.DeploymentService;
import com.cloud.api.service.PodService;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.RouteService;
import com.cloud.api.service.ServiceService;
import com.cloud.api.util.CamelToUnderline;
import com.cloud.api.util.InvalidationUtils;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@Validated
@RestController
@RequestMapping("/instances")
public class InstanceController {

	private final static Logger log = LoggerFactory.getLogger(InstanceController.class);

	@Resource
	private AppInstanceService appInstanceService;

	@Resource
	private DeploymentService deploymentService;

	@Resource
	private ServiceService serviceService;

	@Resource
	private RouteService routeService;

	@Resource
	private PodService podService;

	@Resource
	private DeploymentMapper deploymentMapper;

	@Resource
	private InvalidationUtils invalidationUtils;

	@Autowired
	private RoleService roleService;

	/**
	 * 查看instance的Deployment中的history
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}/history")
	@ResponseBody
	public String getDeploymentHistory(@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		DeploymentDTO deployment = appInstanceService.getInstanceDeployment(id);
		return JsonUtils.objectToJsonPretty(ResultGenerator.genGetOkResult(deployment));
	}

	/**
	 * 获取instance的Deployment中的configuration
	 * 
	 */
	@GetMapping("/{id}/configuration")
	@ResponseBody
	public Result<?> getDeploymentConfiguration(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_DEPLOYMENT, Constants.ACTION_QUERY);

		String instanceId = id;
		AppInstanceDetailDO deploymentDO = deploymentService.getDeploymentDO(instanceId);
		// get last deployment
		String deploymentName = deploymentDO.getMetadata().getName();
		String project = deploymentDO.getMetadata().getNamespace();
//		AppInstanceDetailDO deployment = deploymentService.getOpenshiftDeployment(project, deploymentName, token);
		AppInstanceDetailDO deployment=deploymentService.getDeploymentDO(instanceId);
		if (deployment != null) {
			String data = JsonUtils.objectToJson(deployment);
			return ResultGenerator.genGetOkResult(data);
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 更新instance的Deployment中的configuration
	 * 
	 */
	@PutMapping("/{id}/configuration")
	@ResponseBody
	@Operation(action = "edit deployment", resourceType = "deployment")
	public Result<?> updateDeploymentConfiguration(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<AppInstanceDetailDO> requestBody, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_DEPLOYMENT, Constants.ACTION_MODIFY);

		String instanceId = id;
		AppInstanceDetailDO deploymentDO = requestBody.getData();
		invalidationUtils.checkInstance(deploymentDO, requestBody.getProject());
		invalidationUtils.checkQuotaUpdate(deploymentDO, requestBody.getProject(), instanceId);
		// name一致
		if (deploymentDO.getMetadata() != null && deploymentDO.getMetadata().getName() != null) {
			String dbName = "";
			DeploymentDTOExample example = new DeploymentDTOExample();
			com.cloud.api.dto.DeploymentDTOExample.Criteria criteria = example.createCriteria();
			criteria.andInstanceIdEqualTo(instanceId);
			List<DeploymentDTO> depList = deploymentMapper.selectByExample(example);
			if (depList != null && !depList.isEmpty()) {
				dbName = depList.get(0).getName();
			}
			if (!dbName.equals(deploymentDO.getMetadata().getName())) {
				throw new ParamInvalidException("deloyment name is not matched!");
			}
		}
		AppInstanceDetailDO instanceResponse = deploymentService.updateOpenShiftDeployment(deploymentDO, instanceId,
				token, requestBody.getProject());
		return ResultGenerator.genGetOkResult(instanceResponse);
	}

	/**
	 * 查看instance的Deployment中的history
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}/pods")
	@ResponseBody
	public Result<?> getDeploymentPods(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<PodRequest> requestBody, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_PODS, Constants.ACTION_QUERY);

		long allCount;
		long filterCount;
		List<PodResponseData> pageList = null;
		String sortStr = "";
		String instanceId = id;
//		allCount
//			allCount = podService.countPod();
//		Sort
		PodRequest dataDO = requestBody.getData();
//			List<GetListParamElement> filterList = dataDO.getFilter();
		List<GetListParamElement> sortList = dataDO.getSort();
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
		List<PodResponseData> dataList = podService.getPodList(instanceId);
		if (dataList != null && !dataList.isEmpty()) {
			PageInfo<PodResponseData> page = new PageInfo<PodResponseData>(dataList);
			filterCount = page.getTotal();
			allCount = page.getTotal();
			pageList = page.getList();
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		}
		// list为空
		return ResultGenerator.genFailedResult();
	}

	/**
	 * 查看instance的Route
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}/route")
	@ResponseBody
	public Result<?> getRouteDetail(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_ROUTE, Constants.ACTION_QUERY);

		RouteDTO routeDTO = routeService.queryRouteByInstanceId(id);
		AppInstanceDetailDO routeDO = new AppInstanceDetailDO();
		RouteDetailResponse routeResponse = new RouteDetailResponse();
		if (routeDTO != null) {
			routeDO.setMetadata(JsonUtils.jsonToObject(routeDTO.getMetadata(), MetaDataDO.class));
			routeDO.setSpec(JsonUtils.jsonToObject(routeDTO.getSpec(), SpecDO.class));
			routeResponse.setHost(routeDO.getSpec().getHost());
			routeResponse.setName(routeDO.getMetadata().getName());
			if (routeDO.getSpec().getTo() != null) {
				if ("Service".equals(routeDO.getSpec().getTo().getKind())) {
					routeResponse.setServiceName(routeDO.getSpec().getTo().getName());
					routeResponse.setServiceWeight(routeDO.getSpec().getTo().getWeight());
				}
			}
			if (routeDO.getMetadata().getLabels() != null) {
				routeResponse.setLabels(routeDO.getMetadata().getLabels().get("app"));
			}

		} else {
			ResultGenerator.genFailedResult("no found matched route!");
		}
		return ResultGenerator.genGetOkResult(routeResponse);
	}

	/**
	 * 查看instance的Service
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}/service")
	@ResponseBody
	public Result<?> getInstanceService(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_SERVICE, Constants.ACTION_QUERY);

		ServiceDTO serviceDTO = serviceService.queryServiceByInstanceId(id);
		AppInstanceDetailDO serviceDO = new AppInstanceDetailDO();
		ServiceDetailResponse serviceResponse = new ServiceDetailResponse();
		if (serviceDTO != null) {
			serviceDO.setMetadata(JsonUtils.jsonToObject(serviceDTO.getMetadata(), MetaDataDO.class));
			serviceDO.setSpec(JsonUtils.jsonToObject(serviceDTO.getSpec(), SpecDO.class));
			List<PortsDO> postsList = serviceDO.getSpec().getPorts();
			log.warn("postsList.size()" + postsList.size());
			// 组装response
			serviceResponse.setName(serviceDO.getMetadata().getName());
			serviceResponse.setIp(serviceDO.getSpec().getClusterIP());
			serviceResponse.setPorts(postsList);
			serviceResponse.setSessionAffinity(serviceDO.getSpec().getSessionAffinity());
			serviceResponse.setType(serviceDO.getSpec().getType());
			if(serviceDO.getMetadata().getLabels()!=null) {
				serviceResponse.setLabels(serviceDO.getMetadata().getLabels().get("app"));
			}
		} else {
			ResultGenerator.genFailedResult("no found matched service!");
		}
		return ResultGenerator.genGetOkResult(serviceResponse);
	}

	@PutMapping("/{id}/service")
	@ResponseBody
	@Operation(action = "edit service", resourceType = "service")
	public Result<?> updateServiceByInstanceId(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<ServiceDetailResponse> requestBody, @PathVariable String id) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_SERVICE, Constants.ACTION_MODIFY);

		ServiceDetailResponse service = requestBody.getData();
		List<PortsDO> portsList = service.getPorts();
		if (portsList == null || portsList.size() == 0) {
			throw new ParamInvalidException("the ports can't be null");
		}
		SpecDO specDO = new SpecDO();
		specDO.setPorts(portsList);
		AppInstanceDetailDO appInstanceDetail = new AppInstanceDetailDO();
		appInstanceDetail.setSpec(specDO);
		ServiceDetailResponse resopnse = serviceService.updateServiceByInstanceId(id, appInstanceDetail, token, requestBody.getProject());
		return ResultGenerator.genGetOkResult(resopnse);
	}

	/**
	 * 删除appInstance
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	@Operation(action = "delete instance", resourceType = "instance")
	public Result<Object> deleteAppInstance(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<InstanceRequest> requestBody, @PathVariable String id) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_INSTANCES,Constants.ACTION_DELETE);
		appInstanceService.deleteAppInstance(id, token, requestBody.getProject());
		return ResultGenerator.genOkResult();
	}

	/**
	 * 回滚appInstance
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	@ResponseBody
	public Result<Object> rollBackAppInstance(@ApiIgnore @TokenParam TokenDO token, @PathVariable String id) {
//		appInstanceService.deleteAppInstance(id, token);
		return ResultGenerator.genOkResult();
	}

	/**
	 * 编辑模板
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	@Operation(action = "edit instance", resourceType = "instance")
	public Result<Object> editAppInstance(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<InstanceRequest> requestBody, @PathVariable String id) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_INSTANCES,Constants.ACTION_MODIFY);
		appInstanceService.editAppInstanceByAppId(token, requestBody.getData(), id, requestBody.getProject());
		return ResultGenerator.genOkResult();

	}

}
