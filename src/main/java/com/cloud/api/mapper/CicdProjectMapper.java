package com.cloud.api.mapper;

import com.cloud.api.dto.CicdProjectDTO;
import com.cloud.api.dto.CicdProjectDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CicdProjectMapper {
    long countByExample(CicdProjectDTOExample example);

    int deleteByExample(CicdProjectDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(CicdProjectDTO record);

    int insertSelective(CicdProjectDTO record);

    List<CicdProjectDTO> selectByExample(CicdProjectDTOExample example);

    CicdProjectDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") CicdProjectDTO record, @Param("example") CicdProjectDTOExample example);

    int updateByExample(@Param("record") CicdProjectDTO record, @Param("example") CicdProjectDTOExample example);

    int updateByPrimaryKeySelective(CicdProjectDTO record);

    int updateByPrimaryKey(CicdProjectDTO record);
}