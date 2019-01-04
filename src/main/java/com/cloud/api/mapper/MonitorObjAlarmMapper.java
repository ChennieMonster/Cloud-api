package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorObjAlarmDTO;
import com.cloud.api.dto.MonitorObjAlarmDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorObjAlarmMapper {
    long countByExample(MonitorObjAlarmDTOExample example);

    int deleteByExample(MonitorObjAlarmDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(MonitorObjAlarmDTO record);

    int insertSelective(MonitorObjAlarmDTO record);

    List<MonitorObjAlarmDTO> selectByExample(MonitorObjAlarmDTOExample example);

    MonitorObjAlarmDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") MonitorObjAlarmDTO record, @Param("example") MonitorObjAlarmDTOExample example);

    int updateByExample(@Param("record") MonitorObjAlarmDTO record, @Param("example") MonitorObjAlarmDTOExample example);

    int updateByPrimaryKeySelective(MonitorObjAlarmDTO record);

    int updateByPrimaryKey(MonitorObjAlarmDTO record);
}