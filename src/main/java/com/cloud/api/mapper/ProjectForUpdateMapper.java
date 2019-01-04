package com.cloud.api.mapper;

import com.cloud.api.dto.ProjectForUpdateDTO;
import com.cloud.api.dto.ProjectForUpdateDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectForUpdateMapper {
    long countByExample(ProjectForUpdateDTOExample example);

    int deleteByExample(ProjectForUpdateDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(ProjectForUpdateDTO record);

    int insertSelective(ProjectForUpdateDTO record);

    List<ProjectForUpdateDTO> selectByExample(ProjectForUpdateDTOExample example);

    ProjectForUpdateDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ProjectForUpdateDTO record, @Param("example") ProjectForUpdateDTOExample example);

    int updateByExample(@Param("record") ProjectForUpdateDTO record, @Param("example") ProjectForUpdateDTOExample example);

    int updateByPrimaryKeySelective(ProjectForUpdateDTO record);

    int updateByPrimaryKey(ProjectForUpdateDTO record);
}