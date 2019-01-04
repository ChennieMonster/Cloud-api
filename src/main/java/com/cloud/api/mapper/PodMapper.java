package com.cloud.api.mapper;

import com.cloud.api.dto.PodDTO;
import com.cloud.api.dto.PodDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PodMapper {
    long countByExample(PodDTOExample example);

    int deleteByExample(PodDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(PodDTO record);

    int insertSelective(PodDTO record);

    List<PodDTO> selectByExample(PodDTOExample example);

    PodDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") PodDTO record, @Param("example") PodDTOExample example);

    int updateByExample(@Param("record") PodDTO record, @Param("example") PodDTOExample example);

    int updateByPrimaryKeySelective(PodDTO record);

    int updateByPrimaryKey(PodDTO record);
}