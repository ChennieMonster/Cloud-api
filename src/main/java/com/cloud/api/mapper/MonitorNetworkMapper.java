package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorNetworkDTO;
import com.cloud.api.dto.MonitorNetworkDTOExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface MonitorNetworkMapper {
    long countByExample(MonitorNetworkDTOExample example);

    int deleteByExample(MonitorNetworkDTOExample example);

    int deleteByPrimaryKey(String id);

    int insert(MonitorNetworkDTO record);

    int insertSelective(MonitorNetworkDTO record);

    List<MonitorNetworkDTO> selectByExample(MonitorNetworkDTOExample example);

    MonitorNetworkDTO selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MonitorNetworkDTO record, @Param("example") MonitorNetworkDTOExample example);

    int updateByExample(@Param("record") MonitorNetworkDTO record, @Param("example") MonitorNetworkDTOExample example);

    int updateByPrimaryKeySelective(MonitorNetworkDTO record);

    int updateByPrimaryKey(MonitorNetworkDTO record);
    
    List<MonitorNetworkDTO> selectMonitorGroupByTime(Map<String, Object> param);
    
    List<MonitorNetworkDTO> selectAppMonitorGroupByTime(Map<String, Object> param);
}