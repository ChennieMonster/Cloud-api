package com.cloud.api.mapper;

import com.cloud.api.dto.LayerDTO;
import com.cloud.api.dto.LayerDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LayerMapper {
    long countByExample(LayerDTOExample example);

    int deleteByExample(LayerDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(LayerDTO record);

    int insertSelective(LayerDTO record);

    List<LayerDTO> selectByExample(LayerDTOExample example);

    LayerDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") LayerDTO record, @Param("example") LayerDTOExample example);

    int updateByExample(@Param("record") LayerDTO record, @Param("example") LayerDTOExample example);

    int updateByPrimaryKeySelective(LayerDTO record);

    int updateByPrimaryKey(LayerDTO record);
    
    int deleteLayerByImageId(String imageId);
    
    int deleteLayerByRegistryId(String registryId);
}