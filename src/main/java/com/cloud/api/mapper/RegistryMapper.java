package com.cloud.api.mapper;

import com.cloud.api.dto.RegistryDTO;
import com.cloud.api.dto.RegistryDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RegistryMapper {
    long countByExample(RegistryDTOExample example);

    int deleteByExample(RegistryDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(RegistryDTO record);

    int insertSelective(RegistryDTO record);

    List<RegistryDTO> selectByExample(RegistryDTOExample example);

    RegistryDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") RegistryDTO record, @Param("example") RegistryDTOExample example);

    int updateByExample(@Param("record") RegistryDTO record, @Param("example") RegistryDTOExample example);

    int updateByPrimaryKeySelective(RegistryDTO record);

    int updateByPrimaryKey(RegistryDTO record);
}