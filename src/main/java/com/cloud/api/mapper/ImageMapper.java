package com.cloud.api.mapper;

import com.cloud.api.dto.ImageDTO;
import com.cloud.api.dto.ImageDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ImageMapper {
    long countByExample(ImageDTOExample example);

    int deleteByExample(ImageDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(ImageDTO record);

    int insertSelective(ImageDTO record);

    List<ImageDTO> selectByExample(ImageDTOExample example);

    ImageDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ImageDTO record, @Param("example") ImageDTOExample example);

    int updateByExample(@Param("record") ImageDTO record, @Param("example") ImageDTOExample example);

    int updateByPrimaryKeySelective(ImageDTO record);

    int updateByPrimaryKey(ImageDTO record);
}