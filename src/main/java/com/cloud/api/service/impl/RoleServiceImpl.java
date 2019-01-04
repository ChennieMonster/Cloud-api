package com.cloud.api.service.impl;

import com.cloud.api.core.constant.MDCConstants;
import com.cloud.api.core.exception.ServiceException;
import com.cloud.api.dto.RoleAuthDTO;
import com.cloud.api.dto.RoleDTO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.entity.request.RoleAuthRequest;
import com.cloud.api.entity.request.RoleDetailRequest;
import com.cloud.api.entity.request.RoleRequest;
import com.cloud.api.mapper.RoleAuthMapper;
import com.cloud.api.mapper.RoleMapper;
import com.cloud.api.mapper.UserMapper;
import com.cloud.api.service.RoleService;
import com.cloud.api.util.IdGen;
import com.cloud.api.util.MessageUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
public class RoleServiceImpl implements RoleService {

    private final static Logger log = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    RoleAuthMapper roleAuthMapper;

    @Transactional
    @Override
    public void addRole(RoleRequest requestData, TokenDO token) {

        log.info("addRole begin, name = " + requestData.getRoleName());

        // 判断是否有重名的
        RoleDTO roleInTable = roleMapper.queryRoleByName(requestData.getRoleName());
        if (roleInTable != null) {
            throw new ServiceException(MessageUtils.getMessage("role.name.has.exists"));
        }

        // 添加角色
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setUuid(IdGen.uuid());
        roleDTO.setRoleName(requestData.getRoleName());
        roleDTO.setRoleType(requestData.getRoleType());
        roleDTO.setRemark(requestData.getRemark());
        Date date = new Date();
        roleDTO.setCreateTime(date);
        roleDTO.setUpdateTime(date);
        roleDTO.setCreateUsername(MDC.get(MDCConstants.USER_NAME));
        roleMapper.addRole(roleDTO);

        // 添加角色权限
        if (requestData.getAuthList() != null && !requestData.getAuthList().isEmpty()) {
            List<RoleAuthDTO> roleAuthDTOList = new ArrayList<RoleAuthDTO>();
            for (RoleAuthRequest roleAuthRequest : requestData.getAuthList()) {
                RoleAuthDTO roleAuthDTO = new RoleAuthDTO();
                roleAuthDTO.setUuid(IdGen.uuid());
                roleAuthDTO.setRoleId(roleDTO.getUuid());
                roleAuthDTO.setModuleName(roleAuthRequest.getModuleName());
                roleAuthDTO.setActionAuth(roleAuthRequest.getActionAuth());

                roleAuthDTOList.add(roleAuthDTO);
            }
            roleAuthMapper.addRoleAuth(roleAuthDTOList);
        }

        log.info("addRole end");
    }

    @Transactional
    @Override
    public void editRole(RoleRequest requestData, TokenDO token) {
        log.info("editRole begin, uuid = " + requestData.getUuid());

        // 判断是否有重名的
        RoleDTO roleInTable = roleMapper.queryRoleByName(requestData.getRoleName());
        if (roleInTable != null && !roleInTable.getUuid().equals(requestData.getUuid())) {
            throw new ServiceException(MessageUtils.getMessage("role.name.has.exists"));
        }

        // 编辑角色
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setUuid(requestData.getUuid());
        roleDTO.setRoleName(requestData.getRoleName());
        roleDTO.setRoleType(requestData.getRoleType());
        roleDTO.setRemark(requestData.getRemark());
        roleDTO.setUpdateTime(new Date());
        int editCount = roleMapper.editRole(roleDTO);

        // 删除角色权限
        int delCount = 0;
        if (editCount > 0) {
            String delRoleids = "'" + roleDTO.getUuid() + "'";
            delCount = roleAuthMapper.delRoleAuth(delRoleids);
        } else {
            throw new ServiceException(MessageUtils.getMessage("role.edit.fail"));
        }

        // 添加角色权限
        if (requestData.getAuthList() != null && !requestData.getAuthList().isEmpty()) {
            List<RoleAuthDTO> roleAuthDTOList = new ArrayList<RoleAuthDTO>();
            for (RoleAuthRequest roleAuthRequest : requestData.getAuthList()) {
                RoleAuthDTO roleAuthDTO = new RoleAuthDTO();
                roleAuthDTO.setUuid(IdGen.uuid());
                roleAuthDTO.setRoleId(roleDTO.getUuid());
                roleAuthDTO.setModuleName(roleAuthRequest.getModuleName());
                roleAuthDTO.setActionAuth(roleAuthRequest.getActionAuth());

                roleAuthDTOList.add(roleAuthDTO);
            }
            roleAuthMapper.addRoleAuth(roleAuthDTOList);
        }

        log.info("editRole end");
    }

    @Transactional
    @Override
    public void delRole(String delRoleids, TokenDO token) {

        if (StringUtils.isBlank(delRoleids)) {
            throw new ServiceException(MessageUtils.getMessage("role.delete.fail"));
        }

        delRoleids = "'" + delRoleids.replace(",", "','") + "'";

        // 删除角色本身信息
        int delRoleCount = roleMapper.delRole(delRoleids);

        // 删除权限信息
        int delRoleAuthCount = 0;
        if (delRoleCount > 0) {
            delRoleAuthCount = roleAuthMapper.delRoleAuth(delRoleids);
        } else {
            throw new ServiceException(MessageUtils.getMessage("role.delete.fail"));
        }

        // 删除用户角色信息
        int delUserRoleCount = 0;
        if (delRoleAuthCount > 0) {
            Map<String, Object> paramMap = new HashMap<String, Object>();
            paramMap.put("roleIds", delRoleids);
            delUserRoleCount = userMapper.delAllProUser(paramMap);
        } else {
            throw new ServiceException(MessageUtils.getMessage("role.delete.fail"));
        }
    }

    @Override
    public List<RoleDTO> queryRoleList(RoleDTO queryParam) {
        return roleMapper.queryRoleList(queryParam);
    }

    @Override
    public long queryRoleCount(RoleDTO queryParam) {
        return roleMapper.queryRoleCount(queryParam);
    }

    @Override
    public RoleDetailRequest getRoleDetail(String roleId) {
        RoleDTO roleDTO = roleMapper.queryRoleByID(roleId);

        List<RoleAuthDTO> authList = roleAuthMapper.queryRoleAuth(roleId);

        RoleDetailRequest roleDetailRequest = new RoleDetailRequest();
        roleDetailRequest.setUuid(roleDTO.getUuid());
        roleDetailRequest.setRoleName(roleDTO.getRoleName());
        roleDetailRequest.setRoleType(roleDTO.getRoleType());
        roleDetailRequest.setRemark(roleDTO.getRemark());
        roleDetailRequest.setCreateUsername(roleDTO.getCreateUsername());
        roleDetailRequest.setCreateTime(roleDTO.getCreateTime());
        roleDetailRequest.setUpdateTime(roleDTO.getUpdateTime());
        roleDetailRequest.setAuthList(authList);

        return roleDetailRequest;
    }

    @Override
    public List<RoleAuthDTO> queryRoleAuth(String roleId) {
        List<RoleAuthDTO> authList = roleAuthMapper.queryRoleAuth(roleId);
        return authList;
    }

//    @Override
//    public void isHaveActionAuth(String username, String moduleName, String action) {
//        boolean flag = haveActionAuth(username, moduleName, action);
//
//        if (!flag) {
//            throw new ServiceException(username + " don't have the auth '" + action + " of " + moduleName + "'");
//        }
//    }

    @Override
    public void isHaveActionAuth(String username, String region, String project, String moduleName, String action) {
        boolean flag = haveActionAuth(username, region, project, moduleName, action);

        if (false) {
            throw new ServiceException(username + " don't have the auth '" + action + " of " + moduleName + "'");
        }
    }

    @Override
    public List<RoleDetailRequest> getUserRoleList(String username) {
        if (StringUtils.isBlank(username)) {
            return null;
        }

        List<Map<String, String>> roleList = roleMapper.getUserRoleList(username);

        if (roleList != null && roleList.isEmpty()) {
            return null;
        }

        List<RoleDetailRequest> returnList = new ArrayList<RoleDetailRequest>();
        for (Map<String, String> map : roleList) {
            if (map == null) {
                continue;
            }
            List<RoleAuthDTO> authList = roleAuthMapper.queryRoleAuth(map.get("uuid"));

            RoleDetailRequest roleDetailRequest = new RoleDetailRequest();
            roleDetailRequest.setUuid(map.get("uuid"));
            roleDetailRequest.setRoleName(map.get("role_name"));
            roleDetailRequest.setRoleType(map.get("role_type"));
            roleDetailRequest.setRemark(map.get("remark"));
            roleDetailRequest.setCreateUsername(map.get("create_username"));
            roleDetailRequest.setRegion(map.get("region"));
            roleDetailRequest.setProject(map.get("project"));
            roleDetailRequest.setAuthList(authList);

            returnList.add(roleDetailRequest);
        }

        return returnList;
    }

    private boolean haveActionAuth(String username, String moduleName, String action) {
        // 参数有误，返回false
        if (StringUtils.isBlank(username) || StringUtils.isBlank(moduleName) || StringUtils.isBlank(action)) {
            return false;
        }

        // 角色信息有误，返回false
        String roleId = "";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userName", username);
        List<Map<String, Object>> roleList = userMapper.queryUserRoleInfo(paramMap);
        if (roleList != null || roleList.size() > 0) {
            roleId = String.valueOf(roleList.get(0).get("role_id"));
        }
        if (StringUtils.isBlank(roleId)) {
            return false;
        }

        // 获取某角色某菜单下的动作权限信息
        String actions = roleAuthMapper.queryRoleModuleAction(roleId, moduleName);

        if (StringUtils.isBlank(actions)) {
            return false;
        }

        actions = "," + actions + ",";
        if (actions.contains("," + action + ",")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean haveActionAuth(String username, String region, String project, String moduleName, String action) {
        if ("admin".equals(username)) {
            return true;
        }

        // 参数有误，返回false
        if (StringUtils.isBlank(username) || StringUtils.isBlank(moduleName) || StringUtils.isBlank(action)) {
            return false;
        }

        List<Map<String, String>> authList = roleAuthMapper.queryUserAuth(username, moduleName);

        if (authList == null || authList.isEmpty()) {
            return false;
        }

        for (Map<String, String> map : authList) {
            String _region = map.get("region");
            String _project = map.get("project");
            String _roleType = map.get("role_type");
            String _actionName = map.get("action_auth");

            if (!StringUtils.isBlank(_actionName)) {
                _actionName = "," + _actionName + ",";
                if (_actionName.contains("," + action + ",")) {

                    // 系统内置角色
                    if ("0".equals(_roleType)) {
                        return true;
                    }
                    // 用户添加角色
                    else if ("1".equals(_roleType)) {
                        if (StringUtils.isNotBlank(_project) && _project.equals(project)) {
                            return true;
                        } else if (StringUtils.isBlank(_project) && StringUtils.isNotBlank(_region) && _region.equals(region)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

}
