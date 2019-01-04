package com.cloud.api.mapper;

import com.cloud.api.dto.ServiceDTO;
import com.cloud.api.dto.ServiceDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ServiceMapper {
    long countByExample(ServiceDTOExample example);

    int deleteByExample(ServiceDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(ServiceDTO record);

    int insertSelective(ServiceDTO record);

    List<ServiceDTO> selectByExample(ServiceDTOExample example);

    ServiceDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ServiceDTO record, @Param("example") ServiceDTOExample example);

    int updateByExample(@Param("record") ServiceDTO record, @Param("example") ServiceDTOExample example);

    int updateByPrimaryKeySelective(ServiceDTO record);

    int updateByPrimaryKey(ServiceDTO record);
}