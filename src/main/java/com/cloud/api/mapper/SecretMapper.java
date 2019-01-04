package com.cloud.api.mapper;

import com.cloud.api.dto.SecretDTO;
import com.cloud.api.dto.SecretDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecretMapper {
    long countByExample(SecretDTOExample example);

    int deleteByExample(SecretDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(SecretDTO record);

    int insertSelective(SecretDTO record);

    List<SecretDTO> selectByExample(SecretDTOExample example);

    SecretDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") SecretDTO record, @Param("example") SecretDTOExample example);

    int updateByExample(@Param("record") SecretDTO record, @Param("example") SecretDTOExample example);

    int updateByPrimaryKeySelective(SecretDTO record);

    int updateByPrimaryKey(SecretDTO record);
}