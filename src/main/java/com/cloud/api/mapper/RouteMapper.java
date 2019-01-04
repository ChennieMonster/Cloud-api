package com.cloud.api.mapper;

import com.cloud.api.dto.RouteDTO;
import com.cloud.api.dto.RouteDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RouteMapper {
    long countByExample(RouteDTOExample example);

    int deleteByExample(RouteDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(RouteDTO record);

    int insertSelective(RouteDTO record);

    List<RouteDTO> selectByExample(RouteDTOExample example);

    RouteDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") RouteDTO record, @Param("example") RouteDTOExample example);

    int updateByExample(@Param("record") RouteDTO record, @Param("example") RouteDTOExample example);

    int updateByPrimaryKeySelective(RouteDTO record);

    int updateByPrimaryKey(RouteDTO record);
}