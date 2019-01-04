package com.cloud.api.controller;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.response.Result;
import com.cloud.api.core.response.ResultGenerator;
import com.cloud.api.dto.RoleAuthDTO;
import com.cloud.api.dto.RoleDTO;
import com.cloud.api.entity.GetListParamElement;
import com.cloud.api.entity.request.RoleDetailRequest;
import com.cloud.api.entity.request.RoleRequest;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.service.RoleService;
import com.cloud.api.util.CamelToUnderline;
import com.cloud.api.util.StringToUTCDate;
import com.cloud.api.util.annotation.Operation;
import com.cloud.api.util.annotation.TokenParam;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

/**
 * 角色权限管理
 */
@Validated
@RestController
@RequestMapping("/sys/roles")
public class RoleController {

    @Resource
    RoleService roleService;

    private final static Logger log = LoggerFactory.getLogger(RoleController.class);

    /**
     * 新增角色
     *
     * @param token
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @Operation(action = "add role", resourceType = "role")
    public Result<Object> addRole(@ApiIgnore @TokenParam TokenDO token,
                                  @Valid @RequestBody GuiRequestBody<RoleRequest> requestBody) {
        // 检查权限
        roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(), Constants.MODULES_ROLES, Constants.ACTION_ADD);

        // 添加角色
        roleService.addRole(requestBody.getData(), token);

        // 返回结果
        return ResultGenerator.genOkResult();

    }

    /**
     * 编辑角色
     *
     * @param token
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "/{roleId}", method = RequestMethod.PUT)
    @Operation(action = "edit role", resourceType = "role")
    public Result<Object> editRole(@ApiIgnore @TokenParam TokenDO token,
                                   @Valid @RequestBody GuiRequestBody<RoleRequest> requestBody,
                                   @PathVariable String roleId) {
        // 检查权限
        roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(), Constants.MODULES_ROLES, Constants.ACTION_MODIFY);

        // 修改角色
        requestBody.getData().setUuid(roleId);
        roleService.editRole(requestBody.getData(), token);

        // 返回结果
        return ResultGenerator.genOkResult();
    }

    /**
     * 删除角色
     *
     * @param token
     * @param requestBody
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.DELETE)
    @Operation(action = "del role", resourceType = "role")
    public Result<Object> delRoles(@ApiIgnore @TokenParam TokenDO token,
                                   @Valid @RequestBody GuiRequestBody<RoleRequest> requestBody) {
        // 检查权限
        roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(), Constants.MODULES_ROLES, Constants.ACTION_DELETE);

        // 删除角色
        String delRoleids = requestBody.getData().getDelRoleids();
        roleService.delRole(delRoleids, token);

        // 返回结果
        return ResultGenerator.genOkResult();

    }

    /**
     * 查看角色列表信息（分页展示）
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Result<?> getRoleList(@ApiIgnore @TokenParam TokenDO token,
                                 @RequestBody(required = false) GuiRequestBody<RoleRequest> requestBody) {

        // 检查权限 (暂时不判断，因为其他地方会调用此方法)
//        roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(), Constants.MODULES_ROLES, Constants.ACTION_QUERY);

        // 返回信息
        long allCount;
        long filterCount;
        List<RoleDTO> pageList = null;


        try {
            // 查询条件
            RoleDTO queryParam = new RoleDTO();
            List<GetListParamElement> filterList = requestBody.getData().getFilter();
            if (filterList != null && !filterList.isEmpty()) {
                for (int i = 0; i < filterList.size(); i++) {
                    String key = filterList.get(i).getKey();
                    if (key.equals("roleName")) {
                        String value = filterList.get(i).getValue();
                        queryParam.setRoleName(value);
                    } else if (key.equals("createTime")) {
                        String value = filterList.get(i).getValue();
                        String str1 = value.substring(0, value.indexOf("~"));
                        String str2 = value.substring(value.indexOf("~") + 1, value.length());
                        log.info(str1 + "=====" + str2);
                        if (str1.equals("*") && !str2.equals("*")) {
                            Date time = StringToUTCDate.toDate(str2);
                            queryParam.setUpdateTime(time);
                        } else if (!str1.equals("*") && str2.equals("*")) {
                            Date time = StringToUTCDate.toDate(str1);
                            queryParam.setCreateTime(time);
                        } else if (str1.equals(str2) && !str2.equals("*")) {
                            Date time = StringToUTCDate.toDate(str1);
                            queryParam.setCreateTime(time);
                            queryParam.setUpdateTime(time);
                        } else if (!str1.equals("*") && !str2.equals("*")) {
                            Date time1 = StringToUTCDate.toDate(str1);
                            Date time2 = StringToUTCDate.toDate(str2);
                            queryParam.setCreateTime(time1);
                            queryParam.setUpdateTime(time2);
                        }
                    }
                }
            }

            // 分页信息处理
            Integer currentPage = requestBody.getData().getCurrentPage();
            Integer pageSize = requestBody.getData().getPageSize();
            List<GetListParamElement> sortList = requestBody.getData().getSort();
            if (sortList != null && !sortList.isEmpty()) {
                String sortStr = "";
                for (int i = 0; i < sortList.size(); i++) {
                    sortStr += CamelToUnderline.camelToUnderline(sortList.get(i).getKey()) + " " + sortList.get(i).getValue() + ",";
                }
                sortStr = sortStr.substring(0, sortStr.length() - 1);
                PageHelper.startPage(currentPage, pageSize, sortStr);
            } else {
                PageHelper.startPage(currentPage, pageSize);
            }

            // 查询数据
            List<RoleDTO> roleList = roleService.queryRoleList(queryParam);

            // 整理数据（分页信息）
            PageInfo<RoleDTO> page = new PageInfo<RoleDTO>(roleList);
            filterCount = page.getTotal();
            pageList = page.getList();

            // 获取总数
            allCount = roleService.queryRoleCount(queryParam);

            // 返回数据
            return ResultGenerator.genListOkResult(allCount, filterCount, pageList);

        } catch (Exception e) {
            // 异常处理
            log.error(e.toString());
            return ResultGenerator.genFailedResult();
        }
    }

    /**
     * 查询角色的详情信息
     *
     * @param token
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
    public Result<RoleDetailRequest> queryRoleDetail(@ApiIgnore @TokenParam TokenDO token,
                                                     @PathVariable String roleId) {
        // 检查权限 (暂时不判断，因为其他地方会调用此方法)
//        roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(), Constants.MODULES_ROLES, Constants.ACTION_QUERY);


        RoleDetailRequest roleDetailRequest = roleService.getRoleDetail(roleId);
        return ResultGenerator.genGetOkResult(roleDetailRequest);
    }

    /**
     * 查询角色的权限信息
     *
     * @param token
     * @param roleId
     * @return
     */
    @RequestMapping(value = "/{roleId}/auth", method = RequestMethod.GET)
    public Result<List<RoleAuthDTO>> queryRoleAuth(@ApiIgnore @TokenParam TokenDO token,
                                                   @PathVariable String roleId) {
        // 检查权限 (暂时不判断，因为其他地方会调用此方法)
//        roleService.isHaveActionAuth(token.getUserName(), requestBody.getRegion(), requestBody.getProject(), Constants.MODULES_ROLES, Constants.ACTION_QUERY);

        List<RoleAuthDTO> authList = roleService.queryRoleAuth(roleId);
        return ResultGenerator.genGetOkResult(authList);
    }

    /**
     * 查询用户的角色权限信息
     *
     * @param token
     * @param username
     * @return
     */
    @RequestMapping(value = "/{username}/userauth", method = RequestMethod.GET)
    Result<List<RoleDetailRequest>> queryUserAuth(@ApiIgnore @TokenParam TokenDO token,
                                                  @PathVariable String username) {

        List<RoleDetailRequest> authList = roleService.getUserRoleList(username);
        return ResultGenerator.genGetOkResult(authList);
    }

}
