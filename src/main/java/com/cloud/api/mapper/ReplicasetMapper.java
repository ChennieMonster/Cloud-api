package com.cloud.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.api.dto.ReplicasetDTO;
import com.cloud.api.dto.ReplicasetDTOExample;
import com.cloud.api.dto.ReplicasetDTO;

/**
* @author huang_kefei
* @date 2018年9月28日
* 类说明
*/
public interface ReplicasetMapper {
    long countByExample(ReplicasetDTOExample example);

    int deleteByExample(ReplicasetDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(ReplicasetDTO record);

    int insertSelective(ReplicasetDTO record);

    List<ReplicasetDTO> selectByExample(ReplicasetDTOExample example);

    ReplicasetDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ReplicasetDTO record, @Param("example") ReplicasetDTOExample example);

    int updateByExample(@Param("record") ReplicasetDTO record, @Param("example") ReplicasetDTOExample example);

    int updateByPrimaryKeySelective(ReplicasetDTO record);

    int updateByPrimaryKey(ReplicasetDTO record);
}
