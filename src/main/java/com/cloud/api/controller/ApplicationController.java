/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.AppInstanceDTO;
import com.cloud.api.dto.ApplicationDTO;
import com.cloud.api.entity.ApplicationDetailDO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.ApplicationRequest;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.InstanceRequest;
import com.cloud.api.service.AppInstanceService;
import com.cloud.api.service.ApplicationService;
import com.cloud.api.service.RoleService;
import com.cloud.api.util.CamelToUnderline;
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
@RequestMapping("/applications")
public class ApplicationController {

	private final static Logger log = LoggerFactory.getLogger(ApplicationController.class);

	@Resource
	private ApplicationService applicationService;
	
	@Resource
	private AppInstanceService appInstanceService;
	
	@Resource
	private RoleService roleService;

	/**
	 * 打开页面默认查询全部
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("")
	@ResponseBody
	public Result<?> getApplicationList(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<ApplicationRequest> requestBody) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_APPLICATIONS,Constants.ACTION_QUERY);
		
		long allCount;
		long filterCount;
		List<ApplicationDTO> pageList = null;
		String sortStr = "";
		try {

//		allCount
			allCount = applicationService.countApplication();
//		Sort
			ApplicationRequest dataDO = requestBody.getData();
			List<GetListParamElement> filterList = dataDO.getFilter();
			List<GetListParamElement> sortList = dataDO.getSort();
			if(sortList != null && !sortList.isEmpty()) {
				for (int i = 0; i < sortList.size(); i++) {
					sortStr += CamelToUnderline.camelToUnderline(sortList.get(i).getKey()) + " "
							+ sortList.get(i).getValue() + ",";
				}
				sortStr = sortStr.substring(0, sortStr.length() - 1);
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize(), sortStr);
			}else {
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize());
			}
//		Filter-----Display Name,Status,Description,CreatedTime
			List<ApplicationDTO> applicationList = applicationService.filterApplication(filterList,requestBody.getRegion(), requestBody.getProject());
			log.info("size:" + applicationList.size());
//		Page
			PageInfo<ApplicationDTO> page = new PageInfo<ApplicationDTO>(applicationList);
			filterCount = page.getTotal();
			pageList = page.getList();
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.toString());
			return ResultGenerator.genFailedResult();
		}
	}

	/**
	 * 查看applicaiton详细
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Result<ApplicationDetailDO> getApplicationDetail(@RequestBody GuiRequestBody<ApplicationRequest> requestBody, @ApiIgnore @TokenParam TokenDO token,
			@PathVariable String id) {

		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_APPLICATION,Constants.ACTION_QUERY);
		ApplicationDetailDO applicationDetailDO = applicationService.getApplicationDetail(id);
		return ResultGenerator.genGetOkResult(applicationDetailDO);

	}

	/**
	 * 添加application
	 */
	@PostMapping("")
	@ResponseBody
	@Operation(action="add application", resourceType="application")
	public Result<Object> addApplication(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<ApplicationRequest> requestBody) {
		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_APPLICATIONS,Constants.ACTION_ADD);
		applicationService.addApplication(requestBody.getData(), token, requestBody.getRegion(), requestBody.getProject());
		return ResultGenerator.genOkResult();
	}

	/**
	 * 批量删除application
	 */
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	@Operation(action="delete application", resourceType="application")
	public Result<?> deleteApplications(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<ApplicationRequest> requestBody) {

		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_APPLICATIONS,Constants.ACTION_DELETE);
		List<String> ids = (requestBody.getData()).getIds();

		// 从库中批量删除
		boolean ifSuccess = applicationService.deleteApplications(token, ids, requestBody.getProject());
		if (ifSuccess) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 编辑模板
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	@Operation(action="edit application", resourceType="application")
	public Result<Object> editApplication(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<ApplicationRequest> requestBody, @PathVariable String id) {

		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_APPLICATIONS,Constants.ACTION_MODIFY);
		applicationService.updateApplication(token, requestBody.getData(), id, requestBody.getProject());
		return ResultGenerator.genOkResult();

	}
	
	/**
	 * 查看instance一览
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping(value = "/{id}/instance")
	@ResponseBody
	public Result<?> getInstanceList(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<InstanceRequest> requestBody, @PathVariable String id) {

		//权限校验
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_INSTANCES,Constants.ACTION_QUERY);
		long allCount;
		long filterCount;
		List<AppInstanceDTO> pageList = null;
		String sortStr = "";
		try {

//		allCount
			allCount = appInstanceService.countAppInstance(id);
			InstanceRequest dataDO = requestBody.getData();
			List<GetListParamElement> filterList = dataDO.getFilter();
			List<GetListParamElement> sortList = dataDO.getSort();
			if(sortList != null && !sortList.isEmpty()) {
				for (int i = 0; i < sortList.size(); i++) {
					sortStr += CamelToUnderline.camelToUnderline(sortList.get(i).getKey()) + " "
							+ sortList.get(i).getValue() + ",";
				}
				sortStr = sortStr.substring(0, sortStr.length() - 1);
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize(), sortStr);
			}else {
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize());
			}
			List<AppInstanceDTO> appInstanceList = appInstanceService.filterInstance(filterList, id);
			log.info("size:" + appInstanceList.size());
			PageInfo<AppInstanceDTO> page = new PageInfo<AppInstanceDTO>(appInstanceList);
			filterCount = page.getTotal();
			pageList = page.getList();
			return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
		} catch (Exception e) {
			// TODO: handle exception
			log.error(e.toString());
			return ResultGenerator.genFailedResult();
		}

	}

}
