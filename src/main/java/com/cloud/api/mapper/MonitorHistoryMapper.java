package com.cloud.api.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cloud.api.dto.MonitorHistoryDTO;
import com.cloud.api.dto.MonitorHistoryDTOExample;

public interface MonitorHistoryMapper {
    long countByExample(MonitorHistoryDTOExample example);

    int deleteByExample(MonitorHistoryDTOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MonitorHistoryDTO record);

    int insertSelective(MonitorHistoryDTO record);

    List<MonitorHistoryDTO> selectByExample(MonitorHistoryDTOExample example);

    MonitorHistoryDTO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MonitorHistoryDTO record, @Param("example") MonitorHistoryDTOExample example);

    int updateByExample(@Param("record") MonitorHistoryDTO record, @Param("example") MonitorHistoryDTOExample example);

    int updateByPrimaryKeySelective(MonitorHistoryDTO record);

    int updateByPrimaryKey(MonitorHistoryDTO record);
    
    List<MonitorHistoryDTO> selectMonitorHistoryGroupByTime(Map<String, Object> param);
    
    List<MonitorHistoryDTO> selectAppMonitorHistoryGroupByTime(Map<String, Object> param);
}