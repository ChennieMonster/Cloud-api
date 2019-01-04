package com.cloud.api.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cloud.api.dto.DeploymentDTO;
import com.cloud.api.dto.DeploymentDTOExample;

/**
 * @author huang_kefei
 * @date 2018年9月28日 类说明
 */
public interface DeploymentMapper {
	  long countByExample(DeploymentDTOExample example);

	    int deleteByExample(DeploymentDTOExample example);

	    int deleteByPrimaryKey(String uuid);

	    int insert(DeploymentDTO record);

	    int insertSelective(DeploymentDTO record);

	    List<DeploymentDTO> selectByExample(DeploymentDTOExample example);

	    DeploymentDTO selectByPrimaryKey(String uuid);

	    int updateByExampleSelective(@Param("record") DeploymentDTO record, @Param("example") DeploymentDTOExample example);

	    int updateByExample(@Param("record") DeploymentDTO record, @Param("example") DeploymentDTOExample example);

	    int updateByPrimaryKeySelective(DeploymentDTO record);

	    int updateByPrimaryKey(DeploymentDTO record);
}
