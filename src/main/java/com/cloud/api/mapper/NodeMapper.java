package com.cloud.api.mapper;

import com.cloud.api.dto.NodeDTO;
import com.cloud.api.dto.NodeDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NodeMapper {
    long countByExample(NodeDTOExample example);

    int deleteByExample(NodeDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(NodeDTO record);

    int insertSelective(NodeDTO record);

    List<NodeDTO> selectByExample(NodeDTOExample example);

    NodeDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") NodeDTO record, @Param("example") NodeDTOExample example);

    int updateByExample(@Param("record") NodeDTO record, @Param("example") NodeDTOExample example);

    int updateByPrimaryKeySelective(NodeDTO record);

    int updateByPrimaryKey(NodeDTO record);
}