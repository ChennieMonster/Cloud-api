package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorContainerDTO;
import com.cloud.api.dto.MonitorContainerDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorContainerMapper {
    long countByExample(MonitorContainerDTOExample example);

    int deleteByExample(MonitorContainerDTOExample example);

    int deleteByPrimaryKey(String conCloudId);

    int insert(MonitorContainerDTO record);

    int insertSelective(MonitorContainerDTO record);

    List<MonitorContainerDTO> selectByExample(MonitorContainerDTOExample example);

    MonitorContainerDTO selectByPrimaryKey(String conCloudId);

    int updateByExampleSelective(@Param("record") MonitorContainerDTO record, @Param("example") MonitorContainerDTOExample example);

    int updateByExample(@Param("record") MonitorContainerDTO record, @Param("example") MonitorContainerDTOExample example);

    int updateByPrimaryKeySelective(MonitorContainerDTO record);

    int updateByPrimaryKey(MonitorContainerDTO record);
}