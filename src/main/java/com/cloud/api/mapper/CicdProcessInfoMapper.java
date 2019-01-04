package com.cloud.api.mapper;

import com.cloud.api.dto.CicdProcessInfoDTO;
import com.cloud.api.dto.CicdProcessInfoDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CicdProcessInfoMapper {
    long countByExample(CicdProcessInfoDTOExample example);

    int deleteByExample(CicdProcessInfoDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(CicdProcessInfoDTO record);

    int insertSelective(CicdProcessInfoDTO record);

    List<CicdProcessInfoDTO> selectByExample(CicdProcessInfoDTOExample example);

    CicdProcessInfoDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") CicdProcessInfoDTO record, @Param("example") CicdProcessInfoDTOExample example);

    int updateByExample(@Param("record") CicdProcessInfoDTO record, @Param("example") CicdProcessInfoDTOExample example);

    int updateByPrimaryKeySelective(CicdProcessInfoDTO record);

    int updateByPrimaryKey(CicdProcessInfoDTO record);
}