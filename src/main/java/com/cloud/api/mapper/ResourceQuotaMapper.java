package com.cloud.api.mapper;

import com.cloud.api.dto.ResourceQuotaDTO;
import com.cloud.api.dto.ResourceQuotaDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceQuotaMapper {
    long countByExample(ResourceQuotaDTOExample example);

    int deleteByExample(ResourceQuotaDTOExample example);

    int insert(ResourceQuotaDTO record);

    int insertSelective(ResourceQuotaDTO record);

    List<ResourceQuotaDTO> selectByExample(ResourceQuotaDTOExample example);

    int updateByExampleSelective(@Param("record") ResourceQuotaDTO record, @Param("example") ResourceQuotaDTOExample example);

    int updateByExample(@Param("record") ResourceQuotaDTO record, @Param("example") ResourceQuotaDTOExample example);
}