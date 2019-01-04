package com.cloud.api.mapper;

import com.cloud.api.dto.UserRoleProDTO;
import com.cloud.api.dto.UserRoleProDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleProMapper {
    long countByExample(UserRoleProDTOExample example);

    int deleteByExample(UserRoleProDTOExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(UserRoleProDTO record);

    int insertSelective(UserRoleProDTO record);

    List<UserRoleProDTO> selectByExample(UserRoleProDTOExample example);

    UserRoleProDTO selectByPrimaryKey(Integer uuid);

    int updateByExampleSelective(@Param("record") UserRoleProDTO record, @Param("example") UserRoleProDTOExample example);

    int updateByExample(@Param("record") UserRoleProDTO record, @Param("example") UserRoleProDTOExample example);

    int updateByPrimaryKeySelective(UserRoleProDTO record);

    int updateByPrimaryKey(UserRoleProDTO record);
}