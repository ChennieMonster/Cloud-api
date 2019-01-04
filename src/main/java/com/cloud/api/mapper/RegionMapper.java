package com.cloud.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.api.dto.RegionDTO;
import com.cloud.api.dto.RegionDTOExample;

/**
* @author huang_kefei
* @date 2018年10月9日
* 类说明
*/
public interface RegionMapper {
	
	long countByExample(RegionDTOExample example);

    int deleteByExample(RegionDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(RegionDTO record);

    int insertSelective(RegionDTO record);

    List<RegionDTO> selectByExample(RegionDTOExample example);

    RegionDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") RegionDTO record, @Param("example") RegionDTOExample example);

    int updateByExample(@Param("record") RegionDTO record, @Param("example") RegionDTOExample example);

    int updateByPrimaryKeySelective(RegionDTO record);

    int updateByPrimaryKey(RegionDTO record);
    
    
    
}
