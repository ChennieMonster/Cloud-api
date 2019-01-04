package com.cloud.api.mapper;

import com.cloud.api.dto.ApplicationMarketDTO;
import com.cloud.api.dto.ApplicationMarketDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ApplicationMarketMapper {
    long countByExample(ApplicationMarketDTOExample example);

    int deleteByExample(ApplicationMarketDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(ApplicationMarketDTO record);

    int insertSelective(ApplicationMarketDTO record);

    List<ApplicationMarketDTO> selectByExample(ApplicationMarketDTOExample example);

    ApplicationMarketDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ApplicationMarketDTO record, @Param("example") ApplicationMarketDTOExample example);

    int updateByExample(@Param("record") ApplicationMarketDTO record, @Param("example") ApplicationMarketDTOExample example);

    int updateByPrimaryKeySelective(ApplicationMarketDTO record);

    int updateByPrimaryKey(ApplicationMarketDTO record);
}