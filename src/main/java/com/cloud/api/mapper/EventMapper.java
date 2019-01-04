package com.cloud.api.mapper;

import com.cloud.api.dto.EventDTO;
import com.cloud.api.dto.EventDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EventMapper {
    long countByExample(EventDTOExample example);

    int deleteByExample(EventDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(EventDTO record);

    int insertSelective(EventDTO record);

    List<EventDTO> selectByExample(EventDTOExample example);

    EventDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") EventDTO record, @Param("example") EventDTOExample example);

    int updateByExample(@Param("record") EventDTO record, @Param("example") EventDTOExample example);

    int updateByPrimaryKeySelective(EventDTO record);

    int updateByPrimaryKey(EventDTO record);
}