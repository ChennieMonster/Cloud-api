package com.cloud.api.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultCode;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.RegionDTO;
import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.ProjectRequest;
import com.cloud.api.service.DeploymentService;
import com.cloud.api.service.RegionService;
import com.cloud.api.service.impl.RegionServiceImpl;
import com.cloud.api.util.ContextUtils;
import com.cloud.api.util.annotation.TokenParam;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author huang_kefei
 * @date 2018年10月10日 类说明
 */
@Validated
@Controller
@RequestMapping("/regions")
public class RegionController {
	@Autowired
	RegionService regionService;
	
	@Autowired
	DeploymentService deploymentService;

	private static final Logger logger = LoggerFactory.getLogger(RegionController.class);


	@GetMapping
	@ResponseBody
	public Result<?> regionInfo(@ApiIgnore @TokenParam TokenDO token) {
		// TODO
		try {
			logger.warn(MDC.get(MDCConstants.REGION_ID));  
			List<RegionDTO> list = regionService.queryAllRegion();
			logger.info("selectRegion");
			// TODO: handle exception
			return ResultGenerator.genGetOkResult(list);
		} catch (Exception e) {
			// TODO: handle exception
			return ResultGenerator.genFailedResult(ResultCode.SERVICE_EXCEPTION);
		}
	}
}
