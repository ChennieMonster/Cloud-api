package com.cloud.api.mapper;

import com.cloud.api.dto.TagDTO;
import com.cloud.api.dto.TagDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TagMapper {
    long countByExample(TagDTOExample example);

    int deleteByExample(TagDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(TagDTO record);

    int insertSelective(TagDTO record);

    List<TagDTO> selectByExample(TagDTOExample example);

    TagDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") TagDTO record, @Param("example") TagDTOExample example);

    int updateByExample(@Param("record") TagDTO record, @Param("example") TagDTOExample example);

    int updateByPrimaryKeySelective(TagDTO record);

    int updateByPrimaryKey(TagDTO record);
    
    int deleteTagByRegistryId(String registryId);
}