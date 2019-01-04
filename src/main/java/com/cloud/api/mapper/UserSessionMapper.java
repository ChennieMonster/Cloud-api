package com.cloud.api.mapper;

import com.cloud.api.dto.UserSessionDTO;
import com.cloud.api.dto.UserSessionDTOExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface UserSessionMapper {
    long countByExample(UserSessionDTOExample example);

    int deleteByExample(UserSessionDTOExample example);

    int deleteByPrimaryKey(Integer uuid);

    int insert(UserSessionDTO record);

    int insertSelective(UserSessionDTO record);

    List<UserSessionDTO> selectByExample(UserSessionDTOExample example);

    UserSessionDTO selectByPrimaryKey(String userId);

    int updateByExampleSelective(@Param("record") UserSessionDTO record, @Param("example") UserSessionDTOExample example);

    int updateByExample(@Param("record") UserSessionDTO record, @Param("example") UserSessionDTOExample example);

    int updateByPrimaryKeySelective(UserSessionDTO record);

    int updateByPrimaryKey(UserSessionDTO record);

}