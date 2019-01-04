package com.cloud.api.service;

import com.cloud.api.dto.RoleAuthDTO;
import com.cloud.api.dto.RoleDTO;
import com.cloud.api.entity.request.RoleDetailRequest;
import com.cloud.api.entity.request.RoleRequest;
import com.cloud.api.entity.TokenDO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    void addRole(RoleRequest data, TokenDO token);

    void editRole(RoleRequest data, TokenDO token);

    void delRole(String delRoleids, TokenDO token);

    List<RoleDTO> queryRoleList(RoleDTO queryParam);

    long queryRoleCount(RoleDTO queryParam);

    RoleDetailRequest getRoleDetail(String roleId);

    List<RoleAuthDTO> queryRoleAuth(String roleId);

//    void isHaveActionAuth(String username, String moduleName, String action);

    void isHaveActionAuth(String username, String region, String project, String moduleName, String action);

    List<RoleDetailRequest> getUserRoleList(String username);
}
