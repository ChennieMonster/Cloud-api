package com.cloud.api.mapper;

import com.cloud.api.dto.AppMarketVersionDTO;
import com.cloud.api.dto.AppMarketVersionDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AppMarketVersionMapper {
    long countByExample(AppMarketVersionDTOExample example);

    int deleteByExample(AppMarketVersionDTOExample example);

    int insert(AppMarketVersionDTO record);

    int insertSelective(AppMarketVersionDTO record);

    List<AppMarketVersionDTO> selectByExample(AppMarketVersionDTOExample example);

    int updateByExampleSelective(@Param("record") AppMarketVersionDTO record, @Param("example") AppMarketVersionDTOExample example);

    int updateByExample(@Param("record") AppMarketVersionDTO record, @Param("example") AppMarketVersionDTOExample example);
}