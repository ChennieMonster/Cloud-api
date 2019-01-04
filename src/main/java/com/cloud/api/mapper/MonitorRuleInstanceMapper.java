package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorRuleInstanceDTO;
import com.cloud.api.dto.MonitorRuleInstanceDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorRuleInstanceMapper {
    long countByExample(MonitorRuleInstanceDTOExample example);

    int deleteByExample(MonitorRuleInstanceDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(MonitorRuleInstanceDTO record);

    int insertSelective(MonitorRuleInstanceDTO record);

    List<MonitorRuleInstanceDTO> selectByExample(MonitorRuleInstanceDTOExample example);

    MonitorRuleInstanceDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") MonitorRuleInstanceDTO record, @Param("example") MonitorRuleInstanceDTOExample example);

    int updateByExample(@Param("record") MonitorRuleInstanceDTO record, @Param("example") MonitorRuleInstanceDTOExample example);

    int updateByPrimaryKeySelective(MonitorRuleInstanceDTO record);

    int updateByPrimaryKey(MonitorRuleInstanceDTO record);
}