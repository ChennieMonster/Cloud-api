package com.cloud.api.mapper;

import com.cloud.api.dto.LabelDTO;
import com.cloud.api.dto.LabelDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LabelMapper {
    long countByExample(LabelDTOExample example);

    int deleteByExample(LabelDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(LabelDTO record);

    int insertSelective(LabelDTO record);

    List<LabelDTO> selectByExample(LabelDTOExample example);

    LabelDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") LabelDTO record, @Param("example") LabelDTOExample example);

    int updateByExample(@Param("record") LabelDTO record, @Param("example") LabelDTOExample example);

    int updateByPrimaryKeySelective(LabelDTO record);

    int updateByPrimaryKey(LabelDTO record);
}