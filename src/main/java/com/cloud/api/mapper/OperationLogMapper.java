package com.cloud.api.mapper;

import com.cloud.api.dto.OperationLogDTO;
import com.cloud.api.dto.OperationLogDTOExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface OperationLogMapper {
    long countByExample(OperationLogDTOExample example);

    int deleteByExample(OperationLogDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(OperationLogDTO record);

    int insertSelective(OperationLogDTO record);

    List<OperationLogDTO> selectByExample(OperationLogDTOExample example);

    OperationLogDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") OperationLogDTO record, @Param("example") OperationLogDTOExample example);

    int updateByExample(@Param("record") OperationLogDTO record, @Param("example") OperationLogDTOExample example);

    int updateByPrimaryKeySelective(OperationLogDTO record);

    int updateByPrimaryKey(OperationLogDTO record);

    List<OperationLogDTO> queryLogList(@Param("username") String username, @Param("queryParam") OperationLogDTO queryParam);

    long queryLogCount(@Param("username") String username, @Param("queryParam") OperationLogDTO queryParam);
}