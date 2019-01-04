/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.TemplateDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TemplateDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.TemplateRequest;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.TemplateService;
import com.cloud.api.util.CamelToUnderline;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen 模板Controller
 */
@Validated
@Controller
@RequestMapping("/templates")
public class TemplateController {

	private final static Logger log = LoggerFactory.getLogger(TemplateController.class);
	
	@Resource
	private TemplateService templateService;
	
	@Resource
	private RoleService roleService;
	
	/**
	 * 查看template详细
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Result<TemplateDetailDO> templateDetail(@RequestBody GuiRequestBody<TemplateRequest> requestBody, @ApiIgnore @TokenParam TokenDO token,@PathVariable String id) {

		//加权限判断
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES, Constants.ACTION_DETAIL);
		
		TemplateDetailDO templateDetailDO = templateService.getTemplateDetail(id);
		return ResultGenerator.genGetOkResult(templateDetailDO);
	}
	
	/**
	 * 打开页面查询所有的template
	 * 
	 * @param userID
	 * @param model
	 * @return
	 */
	@GetMapping("")
	@ResponseBody
	public Result<?> getTemplateList(@ApiIgnore @TokenParam TokenDO token, @RequestBody GuiRequestBody<TemplateRequest> requestBody) {
		
		//加权限判断
		if(Constants.REGISTRY_TYPE_PLATFORM.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PLATFORM, Constants.ACTION_QUERY);
		}else if(Constants.REGISTRY_TYPE_PRIVATE.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PRIVATE, Constants.ACTION_QUERY);
		}
		
		long allCount;
		long filterCount;
		List<TemplateDTO> pageList = null;
		String sortStr = "";
		try {
//			allCount
			allCount = templateService.countTemplate();
//		Sort
			TemplateRequest dataDO = requestBody.getData();
			List<GetListParamElement> filterList = dataDO.getFilter();
			List<GetListParamElement> sortList = dataDO.getSort();
			String type=dataDO.getType();
			List<TemplateDTO> templateList;
			
			if(sortList!=null&&!sortList.isEmpty()) {
				for (int i = 0; i < sortList.size(); i++) {
					sortStr += CamelToUnderline.camelToUnderline(sortList.get(i).getKey()) + " " + sortList.get(i).getValue() + ",";
				}
				sortStr = sortStr.substring(0, sortStr.length() - 1);
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize(), sortStr);
			}else {
				PageHelper.startPage(dataDO.getCurrentPage(), dataDO.getPageSize());
			}
			
//		Filter-----Display Name,instanceCount,CreatedTime
			if(type!=null && type!="") {
				 templateList = templateService.filterTemplateAndType(filterList, type,requestBody.getRegion(), requestBody.getProject());
			}else {
				 templateList = templateService.filterTemplate(filterList, requestBody.getRegion(), requestBody.getProject());
			}
//		Page
			PageInfo<TemplateDTO> page = new PageInfo<TemplateDTO>(templateList); 
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
	 * 添加模板	
	 */
	@PostMapping("")
	@ResponseBody
	@Operation(action="add template", resourceType="template")
	public Result<Object> addTemplate(@ApiIgnore @TokenParam TokenDO token,
			@Valid @RequestBody GuiRequestBody<TemplateRequest> requestBody) {
		// 加权限判断
		if (Constants.REGISTRY_TYPE_PLATFORM.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PLATFORM,Constants.ACTION_ADD);
		} else if (Constants.REGISTRY_TYPE_PRIVATE.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PRIVATE,Constants.ACTION_ADD);
		}
		templateService.addTemplate(requestBody.getData(), token,requestBody.getRegion(), requestBody.getProject());
		return ResultGenerator.genOkResult();

	}

	/**
	 * 批量删除模板
	 */
	@RequestMapping(value = "", method = RequestMethod.DELETE)
	@ResponseBody
	@Operation(action="delete template", resourceType="template")
	public Result<?> deleteTemplates(@ApiIgnore @TokenParam TokenDO token, @RequestBody GuiRequestBody<TemplateRequest> requestBody) {

		List<String> ids = (requestBody.getData()).getIds();
		
		// 从库中批量删除
		boolean ifSuccess = templateService.deleteTemplates(token, ids, requestBody.getRegion(), requestBody.getProject());
		if(ifSuccess) {
			return ResultGenerator.genOkResult();
		}else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 编辑模板
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ResponseBody
	@Operation(action="edit template", resourceType="template")
	public Result<Object> editTemplate(@ApiIgnore @TokenParam TokenDO token,@Valid @RequestBody GuiRequestBody<TemplateRequest> requestBody, 
			@PathVariable String id) {
		// 加权限判断
		if (Constants.REGISTRY_TYPE_PLATFORM.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PLATFORM,
					Constants.ACTION_MODIFY);
		} else if (Constants.REGISTRY_TYPE_PRIVATE.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PRIVATE,
					Constants.ACTION_MODIFY);
		}
		templateService.editTemplate(token, requestBody.getData(), id, requestBody.getProject());
		return ResultGenerator.genOkResult();

	}
	
	/**
	 * 导入模板
	 */
	@PostMapping(value = { "/upload" })
	@ResponseBody
	@Operation(action="upload template", resourceType="template")
	public Result<Object> uploadTemplate(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<TemplateRequest> requestBody) {
		// 加权限判断
		if (Constants.REGISTRY_TYPE_PLATFORM.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PLATFORM,
					Constants.ACTION_UPLOAD);
		} else if (Constants.REGISTRY_TYPE_PRIVATE.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PRIVATE,
					Constants.ACTION_UPLOAD);
		}
		templateService.uploadTemplate(requestBody.getData(), token,requestBody.getRegion(), requestBody.getProject());
		return ResultGenerator.genOkResult();

	}
	
	/**
	 * 导出模板
	 */
	@PostMapping(value = { "/export" })
	@ResponseBody
	@Operation(action="download template", resourceType="template")
	public Result<Object> exportTemplate(@ApiIgnore @TokenParam TokenDO token,
			@RequestBody GuiRequestBody<TemplateRequest> requestBody, HttpServletResponse response) {
		// 加权限判断
		if (Constants.REGISTRY_TYPE_PLATFORM.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PLATFORM,
					Constants.ACTION_DOWNLOAD);
		} else if (Constants.REGISTRY_TYPE_PRIVATE.equals(requestBody.getData().getType())) {
			roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_TEMPLATES_PRIVATE,
					Constants.ACTION_DOWNLOAD);
		}
		templateService.exportTemplate(requestBody.getData(), token, response);
		return ResultGenerator.genOkResult();

	}

}
