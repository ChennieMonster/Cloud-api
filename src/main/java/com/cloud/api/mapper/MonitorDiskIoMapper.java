package com.cloud.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cloud.api.dto.MonitorDiskIoDTO;
import com.cloud.api.dto.MonitorDiskIoDTOExample;

public interface MonitorDiskIoMapper {
    long countByExample(MonitorDiskIoDTOExample example);

    int deleteByExample(MonitorDiskIoDTOExample example);

    int deleteByPrimaryKey(String id);

    int insert(MonitorDiskIoDTO record);

    int insertSelective(MonitorDiskIoDTO record);

    List<MonitorDiskIoDTO> selectByExample(MonitorDiskIoDTOExample example);

    MonitorDiskIoDTO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MonitorDiskIoDTO record, @Param("example") MonitorDiskIoDTOExample example);

    int updateByExample(@Param("record") MonitorDiskIoDTO record, @Param("example") MonitorDiskIoDTOExample example);

    int updateByPrimaryKeySelective(MonitorDiskIoDTO record);

    int updateByPrimaryKey(MonitorDiskIoDTO record);
    
    List<MonitorDiskIoDTO> selectMonitorDisoIOGroupByTime(Map<String, Object> param);
}