/**
 * 
 */
package com.cloud.api.controller;

import java.util.List;

import javax.annotation.Resource;
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

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.ApplicationMarketDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.AddMarketRequest;
import com.cloud.api.entity.request.DeployAppFromMarketReq;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.response.EditMarketResponse;
import com.cloud.api.entity.response.OpenAppPageResponse;
import com.cloud.api.service.ApplicationMarketService;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageInfo;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author zhao_pengchen
 *
 */
@Validated
@Controller
@RequestMapping("/applicationMarket")
public class ApplicationMarketController {

	private final static Logger log = LoggerFactory.getLogger(ApplicationMarketController.class);
	
	@Resource
	private ApplicationMarketService applicationMarketService;
	
	/**
	 * 查看applicationMarket
	 */
	@GetMapping("")
	@ResponseBody
	public Result<List<ApplicationMarketDTO>> applicationMarkets(@RequestBody GuiRequestBody<DeployAppFromMarketReq> requestBody, @ApiIgnore @TokenParam TokenDO token){
		//过滤
		List<GetListParamElement> filterList = requestBody.getData().getFilter();
		List<ApplicationMarketDTO> appMarketList = applicationMarketService.getApplicationMarkets(filterList, requestBody.getProject());
		//分页
		PageInfo<ApplicationMarketDTO> page = new PageInfo<ApplicationMarketDTO>(appMarketList);
		long filterCount = page.getTotal();
		List<ApplicationMarketDTO> pageList = page.getList();
		return ResultGenerator.genListOkResult(appMarketList.size(), filterCount, pageList);
	}
	
	/**
	 * 查看applicationMarket详细
	 */
	@GetMapping("/{id}")
	@ResponseBody
	public Result<ApplicationMarketDTO> applicationMarket(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id){
		ApplicationMarketDTO appMarket = applicationMarketService.getApplicationMarket(id);
		return ResultGenerator.genGetOkResult(appMarket);
	}
	
	/**
	 * 部署页面供修改信息
	 */
	@GetMapping("/{id}/openAppPage")
	@ResponseBody
	public Result<List<OpenAppPageResponse>> openAppPage(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id){
		List<OpenAppPageResponse> appPageList = applicationMarketService.openAppPage(id);
		return ResultGenerator.genGetOkResult(appPageList);
	}
	
	/**
	 * 部署
	 */
	@PostMapping("")
	@ResponseBody
	public Result<?> deployApp(@Valid @RequestBody GuiRequestBody<DeployAppFromMarketReq> requestBody, @ApiIgnore @TokenParam TokenDO token){
		applicationMarketService.deployApp(requestBody.getData(), token,requestBody.getRegion(), requestBody.getProject());
		return ResultGenerator.genOkResult();
	}
	
	/**
	 * 添加应用市场应用
	 */
	@PostMapping("/addMarket")
	@ResponseBody
	public Result<?> addMarket(@Valid @RequestBody GuiRequestBody<AddMarketRequest> requestBody, @ApiIgnore @TokenParam TokenDO token){
		applicationMarketService.addMarket(requestBody.getData(), token,requestBody.getRegion(), requestBody.getProject());
		return ResultGenerator.genOkResult();
	}
	
	/**
	 * 删除应用市场应用
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result<?> deleteMarket(@Valid @RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id){
		applicationMarketService.deleteMarket(id, token,requestBody.getRegion(), requestBody.getProject());
		return ResultGenerator.genOkResult();
	}
	
	/**
	 * 部署页面供修改信息
	 */
	@GetMapping("/{id}/openEditPage")
	@ResponseBody
	public Result<EditMarketResponse> openEditPage(@RequestBody GuiRequestBody<?> requestBody, @ApiIgnore @TokenParam TokenDO token, @PathVariable String id){
		EditMarketResponse response = applicationMarketService.openEditPage(id);
		return ResultGenerator.genGetOkResult(response);
	}
	
	/**
	 * 修改应用市场应用
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result<?> updateMarket(@Valid @RequestBody GuiRequestBody<AddMarketRequest> requestBody, @ApiIgnore @TokenParam TokenDO token){
		applicationMarketService.updateMarket(requestBody.getData(), token, requestBody.getProject());
		return ResultGenerator.genOkResult();
	}
	
	
}
