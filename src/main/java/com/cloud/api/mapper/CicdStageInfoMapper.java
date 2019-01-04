package com.cloud.api.mapper;

import com.cloud.api.dto.CicdStageInfoDTO;
import com.cloud.api.dto.CicdStageInfoDTOExample;
import com.cloud.api.dto.CicdStageInfoDTOWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CicdStageInfoMapper {
    long countByExample(CicdStageInfoDTOExample example);

    int deleteByExample(CicdStageInfoDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(CicdStageInfoDTOWithBLOBs record);

    int insertSelective(CicdStageInfoDTOWithBLOBs record);

    List<CicdStageInfoDTOWithBLOBs> selectByExampleWithBLOBs(CicdStageInfoDTOExample example);

    List<CicdStageInfoDTO> selectByExample(CicdStageInfoDTOExample example);

    CicdStageInfoDTOWithBLOBs selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") CicdStageInfoDTOWithBLOBs record, @Param("example") CicdStageInfoDTOExample example);

    int updateByExampleWithBLOBs(@Param("record") CicdStageInfoDTOWithBLOBs record, @Param("example") CicdStageInfoDTOExample example);

    int updateByExample(@Param("record") CicdStageInfoDTO record, @Param("example") CicdStageInfoDTOExample example);

    int updateByPrimaryKeySelective(CicdStageInfoDTOWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(CicdStageInfoDTOWithBLOBs record);

    int updateByPrimaryKey(CicdStageInfoDTO record);
}