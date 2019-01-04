package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorAlarmDTO;
import com.cloud.api.dto.MonitorAlarmDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorAlarmMapper {
    long countByExample(MonitorAlarmDTOExample example);

    int deleteByExample(MonitorAlarmDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(MonitorAlarmDTO record);

    int insertSelective(MonitorAlarmDTO record);

    List<MonitorAlarmDTO> selectByExample(MonitorAlarmDTOExample example);

    MonitorAlarmDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") MonitorAlarmDTO record, @Param("example") MonitorAlarmDTOExample example);

    int updateByExample(@Param("record") MonitorAlarmDTO record, @Param("example") MonitorAlarmDTOExample example);

    int updateByPrimaryKeySelective(MonitorAlarmDTO record);

    int updateByPrimaryKey(MonitorAlarmDTO record);
    
    List<MonitorAlarmDTO> selectAllMonitorAlarm();
}