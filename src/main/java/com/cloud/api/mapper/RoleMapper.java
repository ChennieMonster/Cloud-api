package com.cloud.api.mapper;

import com.cloud.api.dto.RoleDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleMapper {

    RoleDTO queryRoleByName(String roleName);

    void addRole(RoleDTO roleDTO);

    int editRole(RoleDTO roleDTO);

    int delRole(String delRoleids);

    List<RoleDTO> queryRoleList(RoleDTO queryParam);

    long queryRoleCount(RoleDTO queryParam);

    RoleDTO queryRoleByID(String roleId);

    List<Map<String, String>> getUserRoleList(String username);
    
}
