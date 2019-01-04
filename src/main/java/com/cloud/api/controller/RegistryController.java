/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.RegistryRequestData;
import com.cloud.api.service.RegistryService;
import com.cloud.api.service.RoleService;
import com.cloud.api.service.ServiceService;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@RestController
@RequestMapping("/registries")
public class RegistryController {

//	private final static Logger log = LoggerFactory.getLogger(RegistryController.class);

	@Resource
	private RegistryService registryService;
	
	@Resource
	private ServiceService serviceService;
	
	@Resource
	private RoleService roleService;
	
	/**
	 * 打开页面默认查询全部
	 * @return
	 */
	@GetMapping
	public Result<List<RegistryDTO>> registryIndex(@ApiIgnore @TokenParam TokenDO token, @RequestBody GuiRequestBody<RegistryRequestData> requestBody) {
		
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "RegistriesSettings", "query");
		
		// 查询用户所拥有权限能操作的registry
		List<RegistryDTO> registryList = registryService.queryRegistryList(requestBody.getProject());
		// TODO
		return ResultGenerator.genListOkResult(registryList.size(), registryList.size(), registryList);
	}
	
	/**
	 * 查询registry详细
	 * @param registryId
	 * @return
	 */
	@GetMapping("{registryId}")
	public Result<RegistryDTO> getRegistryDetail(@ApiIgnore @TokenParam TokenDO token, @PathVariable String registryId, @RequestBody GuiRequestBody<RegistryRequestData> requestBody){
		
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "RegistriesSetting", "query");
		
		RegistryDTO registry = registryService.queryRegistryById(registryId);
		return ResultGenerator.genGetOkResult(registry);
	}
	/**
	 * 添加registry
	 */
	@PostMapping
	@Operation(action="add registry", resourceType="registry")
	public Result<?> addRegistry(@ApiIgnore @TokenParam TokenDO token, @Valid @RequestBody GuiRequestBody<RegistryRequestData> requestBody) {
		
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "RegistriesSettings", "add");
		
		// 入库
		if (registryService.addRegistry(token, requestBody.getData(), requestBody.getProject(),requestBody.getRegion())) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 删除registry
	 */
	@DeleteMapping
	@Operation(action="delete registry", resourceType="registry")
	public Result<?> deleteRegistry(@RequestBody GuiRequestBody<RegistryRequestData> requestBody,@ApiIgnore @TokenParam TokenDO token) {
		
		// 从库中删除
		if (registryService.deleteRegistry(requestBody.getData().getIds(), token, requestBody.getProject(), requestBody.getRegion())) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}

	/**
	 * 编辑模板
	 */
	@PutMapping("/{registryId}")
//	@Operation(action="edit registry", resourceType="registry")
	public Result<?> editRegistry(@PathVariable String registryId,@Valid @RequestBody GuiRequestBody<RegistryRequestData> requestBody, @ApiIgnore @TokenParam TokenDO token) {
		
		roleService.isHaveActionAuth(token.getUserName(),requestBody.getRegion(),requestBody.getProject(), "RegistriesSettings", "modify");
		
		// 从库中修改
		if (registryService.editRegistry(requestBody.getData(), registryId, token, requestBody.getProject())) {
			return ResultGenerator.genOkResult();
		} else {
			return ResultGenerator.genFailedResult();
		}

	}
}
