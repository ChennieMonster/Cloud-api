package com.cloud.api.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.ContainerDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ContainerRequestData;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.response.ContainerDetailResponse;
import com.cloud.api.entity.response.ContainerResponseData;
import com.cloud.api.service.ContainerService;
import com.cloud.api.service.RoleService;
import com.cloud.api.util.JsonUtils;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/pod/{podId}/containers")
public class ContainerController {

	@Resource
	private ContainerService containerService;
	
	@Resource
	private RoleService roleService;

	@PutMapping
	public Result<?> operateContainer(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<ContainerRequestData> requestBody) {
		// check auth
		switch(requestBody.getData().getOperateType()) {
		case Constants.CONTAINER_OPERATE_STOP:
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_CONTAINER, Constants.CONTAINER_OPERATE_STOP);
			break;
		case Constants.CONTAINER_OPERATE_RESTART:
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_CONTAINER, Constants.CONTAINER_OPERATE_RESTART);
			break;
		case Constants.CONTAINER_OPERATE_DELETE:
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_CONTAINER, Constants.CONTAINER_OPERATE_DELETE);
			break;
		case Constants.CONTAINER_OPERATE_RECOVERY:
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_CONTAINER, Constants.CONTAINER_OPERATE_RECOVERY);
			break;
		}
		int code = containerService.operateContainer(requestBody.getData().getContainerId(), requestBody.getData(),requestBody.getProject());
		if(code==200||code==202) {
			return ResultGenerator.genOkResult();
		}else {
			return ResultGenerator.genFailedResult();
		}
	
	}

	
	@SuppressWarnings("unchecked")
	@GetMapping("/{id}")
	public Result<?> getContainerDetail(@ApiIgnore @TokenParam TokenDO token,@RequestBody GuiRequestBody<?> requestBody,@PathVariable String id) {
//		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_CONTAINER, Constants.ACTION_QUERY);
		
		ContainerDTO container = containerService.queryContainerByConId(id);
		
		if(container!=null) {
			ContainerDetailResponse responseGui= new ContainerDetailResponse();
			responseGui.setConId(container.getConId());
			responseGui.setName(container.getName());
			responseGui.setNodeName(container.getNodeName());
			responseGui.setImage(container.getImage());
			responseGui.setCon_detail(container.getConDetail());
			responseGui.setStatus(container.getStatus());
			responseGui.setProcessId(container.getProcessId());
			responseGui.setWorkDir(container.getWorkDir());
			responseGui.setHostName(container.getHostname());
			if(container.getEnv()!=null) {
				responseGui.setEnv(JsonUtils.jsonToObject(container.getEnv(), List.class, Map.class));
			}
			if(container.getVolumes()!=null){
				responseGui.setVolumes(JsonUtils.jsonToObject(container.getVolumes(), List.class,String.class));	
			}
			if(container.getMounts()!=null) {
				responseGui.setMounts(JsonUtils.jsonToObject(container.getMounts(), List.class,Map.class));	
			}
			responseGui.setCreatedTime(container.getCreatedTime());
			//network
			responseGui.setDomainName(container.getDomainName());
			responseGui.setIp(container.getIpAddress());
			if(container.getPorts()!=null) {
				responseGui.setPorts(JsonUtils.jsonToObject(container.getPorts(), Map.class));
			}
			responseGui.setDns(container.getDns());
	
			return ResultGenerator.genGetOkResult(responseGui);
		}
		return ResultGenerator.genFailedResult();
	}
	
	@GetMapping
	public Result<?> getContainer(@ApiIgnore @TokenParam TokenDO token,@RequestBody GuiRequestBody<?> requestBody,@PathVariable String podId) {
		// check auth
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_CONTAINERS, Constants.ACTION_QUERY);
		
		List<ContainerDTO> containers = containerService.queryContainerByPodId(podId);
		List<ContainerResponseData> responseGuiList = new ArrayList<>();
		if(containers!=null&&!containers.isEmpty()) {
			for(ContainerDTO container:containers) {
				ContainerResponseData responseGui= new ContainerResponseData();
				responseGui.setConId(container.getConId());
				responseGui.setName(container.getName());
				responseGui.setStatus(container.getStatus());
				responseGui.setCreatedTime(container.getCreatedTime());
				responseGuiList.add(responseGui);
			}
			return ResultGenerator.genGetOkResult(responseGuiList);
		}
		return ResultGenerator.genFailedResult();
	}
}
