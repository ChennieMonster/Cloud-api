package com.cloud.api.mapper;

import com.cloud.api.dto.QuotaDTO;
import com.cloud.api.dto.QuotaDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QuotaMapper {
    long countByExample(QuotaDTOExample example);

	int deleteByExample(QuotaDTOExample example);

	int deleteByPrimaryKey(String uuid);

	int insert(QuotaDTO record);

	int insertSelective(QuotaDTO record);

	List<QuotaDTO> selectByExample(QuotaDTOExample example);

	QuotaDTO selectByPrimaryKey(String uuid);

	int updateByExampleSelective(@Param("record") QuotaDTO record, @Param("example") QuotaDTOExample example);

	int updateByExample(@Param("record") QuotaDTO record, @Param("example") QuotaDTOExample example);

	int updateByPrimaryKeySelective(QuotaDTO record);

	int updateByPrimaryKey(QuotaDTO record);

}