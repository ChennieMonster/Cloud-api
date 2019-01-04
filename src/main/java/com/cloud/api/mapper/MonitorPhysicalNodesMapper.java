package com.cloud.api.mapper;

import com.cloud.api.dto.MonitorPhysicalNodesDTO;
import com.cloud.api.dto.MonitorPhysicalNodesDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorPhysicalNodesMapper {
    long countByExample(MonitorPhysicalNodesDTOExample example);

    int deleteByExample(MonitorPhysicalNodesDTOExample example);

    int deleteByPrimaryKey(String hostname);

    int insert(MonitorPhysicalNodesDTO record);

    int insertSelective(MonitorPhysicalNodesDTO record);

    List<MonitorPhysicalNodesDTO> selectByExample(MonitorPhysicalNodesDTOExample example);

    MonitorPhysicalNodesDTO selectByPrimaryKey(String hostname);

    int updateByExampleSelective(@Param("record") MonitorPhysicalNodesDTO record, @Param("example") MonitorPhysicalNodesDTOExample example);

    int updateByExample(@Param("record") MonitorPhysicalNodesDTO record, @Param("example") MonitorPhysicalNodesDTOExample example);

    int updateByPrimaryKeySelective(MonitorPhysicalNodesDTO record);

    int updateByPrimaryKey(MonitorPhysicalNodesDTO record);
    
    List<MonitorPhysicalNodesDTO> selectAllMonitorPhysicalNodes();
}