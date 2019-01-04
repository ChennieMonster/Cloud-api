package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorRuleDTO;
import com.cloud.api.dto.MonitorRuleDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorRuleMapper {
    long countByExample(MonitorRuleDTOExample example);

    int deleteByExample(MonitorRuleDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(MonitorRuleDTO record);

    int insertSelective(MonitorRuleDTO record);

    List<MonitorRuleDTO> selectByExample(MonitorRuleDTOExample example);

    MonitorRuleDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") MonitorRuleDTO record, @Param("example") MonitorRuleDTOExample example);

    int updateByExample(@Param("record") MonitorRuleDTO record, @Param("example") MonitorRuleDTOExample example);

    int updateByPrimaryKeySelective(MonitorRuleDTO record);

    int updateByPrimaryKey(MonitorRuleDTO record);
}