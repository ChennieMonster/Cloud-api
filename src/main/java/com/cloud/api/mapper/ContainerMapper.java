package com.cloud.api.mapper;

import com.cloud.api.dto.ContainerDTO;
import com.cloud.api.dto.ContainerDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContainerMapper {
    long countByExample(ContainerDTOExample example);

    int deleteByExample(ContainerDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(ContainerDTO record);

    int insertSelective(ContainerDTO record);

    List<ContainerDTO> selectByExample(ContainerDTOExample example);

    ContainerDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ContainerDTO record, @Param("example") ContainerDTOExample example);

    int updateByExample(@Param("record") ContainerDTO record, @Param("example") ContainerDTOExample example);

    int updateByPrimaryKeySelective(ContainerDTO record);

    int updateByPrimaryKey(ContainerDTO record);
    
    List<String> selectContainersByApplicationId(String applicationId);
}