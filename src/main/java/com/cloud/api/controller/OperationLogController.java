package com.cloud.api.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.dto.RoleDTO;
import com.cloud.api.service.RoleService;
import com.cloud.api.util.StringToUTCDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.OperationLogDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.entity.request.OperationLogRequest;
import com.cloud.api.service.OperationLogService;
import com.cloud.api.util.CamelToUnderline;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

/**
 * @author shi_lin
 */
@RestController
@RequestMapping("/operationLogs")
public class OperationLogController {

    private final static Logger log = LoggerFactory.getLogger(OperationLogController.class);

    @Resource
    RoleService roleService;

    @Resource
    private OperationLogService operationLogService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<?> getOperationLogList(@RequestBody GuiRequestBody<OperationLogRequest> requestBody) {
        // 检查权限 (暂时不判断，因为其他地方会调用此方法)
        roleService.isHaveActionAuth(MDC.get(MDCConstants.USER_NAME),requestBody.getRegion(),requestBody.getProject(), Constants.MODULES_OPERATIONLOGS, Constants.ACTION_QUERY);

        String sortStr = "";

        OperationLogRequest requestData = requestBody.getData();
        List<GetListParamElement> sortList = requestData.getSort();
        if (sortList != null && !sortList.isEmpty()) {
            for (int i = 0; i < sortList.size(); i++) {
                sortStr += CamelToUnderline.camelToUnderline(sortList.get(i).getKey()) + " "
                        + sortList.get(i).getValue() + ",";
            }
            sortStr = sortStr.substring(0, sortStr.length() - 1);
            PageHelper.startPage(requestData.getCurrentPage(), requestData.getPageSize(), sortStr);
        } else {
            PageHelper.startPage(requestData.getCurrentPage(), requestData.getPageSize());
        }

        // 查询条件
        OperationLogDTO queryParam = new OperationLogDTO();
        List<GetListParamElement> filterList = requestData.getFilter();
        if (filterList != null && !filterList.isEmpty()) {
            for (int i = 0; i < filterList.size(); i++) {
                String key = filterList.get(i).getKey();
                if (key.equals("userName")) {
                    String value = filterList.get(i).getValue();
                    queryParam.setUserName(value);
                } else if (key.equals("action")) {
                    String value = filterList.get(i).getValue();
                    queryParam.setAction(value);
                } else if (key.equals("createTime")) {
                    String value = filterList.get(i).getValue();
                    String str1 = value.substring(0, value.indexOf("~"));
                    String str2 = value.substring(value.indexOf("~") + 1, value.length());
                    log.info(str1 + "=====" + str2);
                    if (str1.equals("*") && !str2.equals("*")) {
                        Date time = StringToUTCDate.toDate(str2);
                        queryParam.setEndTime(time);
                    } else if (!str1.equals("*") && str2.equals("*")) {
                        Date time = StringToUTCDate.toDate(str1);
                        queryParam.setStartTime(time);
                    } else if (str1.equals(str2) && !str2.equals("*")) {
                        Date time = StringToUTCDate.toDate(str1);
                        queryParam.setStartTime(time);
                        queryParam.setEndTime(time);
                    } else if (!str1.equals("*") && !str2.equals("*")) {
                        Date time1 = StringToUTCDate.toDate(str1);
                        Date time2 = StringToUTCDate.toDate(str2);
                        queryParam.setStartTime(time1);
                        queryParam.setEndTime(time2);
                    }
                }
            }
        }

        List<OperationLogDTO> logDTOs = operationLogService.filterOperationLog(queryParam);
        log.info("size:" + logDTOs.size());
        PageInfo<OperationLogDTO> page = new PageInfo<OperationLogDTO>(logDTOs);

        long filterCount = page.getTotal();
        List<OperationLogDTO> pageList = page.getList();

        long allCount = operationLogService.queryLogCount(queryParam);
        return ResultGenerator.genListOkResult(allCount, filterCount, pageList);
    }
}
