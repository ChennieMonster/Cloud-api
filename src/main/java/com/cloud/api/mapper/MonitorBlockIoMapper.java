package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorBlockIoDTO;
import com.cloud.api.dto.MonitorBlockIoDTOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MonitorBlockIoMapper {
    long countByExample(MonitorBlockIoDTOExample example);

    int deleteByExample(MonitorBlockIoDTOExample example);

    int deleteByPrimaryKey(String id);

    int insert(MonitorBlockIoDTO record);

    int insertSelective(MonitorBlockIoDTO record);

    List<MonitorBlockIoDTO> selectByExample(MonitorBlockIoDTOExample example);

    MonitorBlockIoDTO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MonitorBlockIoDTO record, @Param("example") MonitorBlockIoDTOExample example);

    int updateByExample(@Param("record") MonitorBlockIoDTO record, @Param("example") MonitorBlockIoDTOExample example);

    int updateByPrimaryKeySelective(MonitorBlockIoDTO record);

    int updateByPrimaryKey(MonitorBlockIoDTO record);
    
    List<MonitorBlockIoDTO> selectMonitorBlockIOGroupByTime(Map<String, Object> param);

    List<MonitorBlockIoDTO> selectAppMonitorBlockIOGroupByTime(Map<String, Object> param);
}