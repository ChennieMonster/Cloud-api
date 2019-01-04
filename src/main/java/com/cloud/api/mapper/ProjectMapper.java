package com.cloud.api.mapper;

import com.cloud.api.dto.ProjectDTO;
import com.cloud.api.dto.ProjectDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    long countByExample(ProjectDTOExample example);

    int deleteByExample(ProjectDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(ProjectDTO record);

    int insertSelective(ProjectDTO record);

    List<ProjectDTO> selectByExample(ProjectDTOExample example);

    ProjectDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") ProjectDTO record, @Param("example") ProjectDTOExample example);

    int updateByExample(@Param("record") ProjectDTO record, @Param("example") ProjectDTOExample example);

    int updateByPrimaryKeySelective(ProjectDTO record);

    int updateByPrimaryKey(ProjectDTO record);
    
    List<ProjectDTO> queryAllProjectByUserAndRegion(@Param("regionId")String regionId, @Param("approveStatus")int approveStatus, @Param("userId")String userId);
}