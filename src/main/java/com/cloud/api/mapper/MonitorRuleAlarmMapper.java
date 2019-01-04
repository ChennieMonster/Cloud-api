package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorRuleAlarmDTO;
import com.cloud.api.dto.MonitorRuleAlarmDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorRuleAlarmMapper {
    long countByExample(MonitorRuleAlarmDTOExample example);

    int deleteByExample(MonitorRuleAlarmDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(MonitorRuleAlarmDTO record);

    int insertSelective(MonitorRuleAlarmDTO record);

    List<MonitorRuleAlarmDTO> selectByExample(MonitorRuleAlarmDTOExample example);

    MonitorRuleAlarmDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") MonitorRuleAlarmDTO record, @Param("example") MonitorRuleAlarmDTOExample example);

    int updateByExample(@Param("record") MonitorRuleAlarmDTO record, @Param("example") MonitorRuleAlarmDTOExample example);

    int updateByPrimaryKeySelective(MonitorRuleAlarmDTO record);

    int updateByPrimaryKey(MonitorRuleAlarmDTO record);
}