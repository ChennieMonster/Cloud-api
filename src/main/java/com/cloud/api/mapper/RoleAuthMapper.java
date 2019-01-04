package com.cloud.api.mapper;

import com.cloud.api.dto.RoleAuthDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface RoleAuthMapper {
    int addRoleAuth(List<RoleAuthDTO> roleAuthDTOList);

    int delRoleAuth(String roleIds);

    List<RoleAuthDTO> queryRoleAuth(String roleId);

    String queryRoleModuleAction(@Param("roleId") String roleId, @Param("moduleName") String moduleName);

    List<Map<String, String>> queryUserAuth(@Param("username") String username, @Param("moduleName") String moduleName);
}
