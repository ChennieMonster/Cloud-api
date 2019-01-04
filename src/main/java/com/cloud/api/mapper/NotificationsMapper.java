package com.cloud.api.mapper;

import com.cloud.api.dto.NotificationsDTO;
import com.cloud.api.dto.NotificationsDTOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotificationsMapper {
    long countByExample(NotificationsDTOExample example);

    int deleteByExample(NotificationsDTOExample example);

    int deleteByPrimaryKey(String uuid);

    int insert(NotificationsDTO record);

    int insertSelective(NotificationsDTO record);

    List<NotificationsDTO> selectByExample(NotificationsDTOExample example);

    NotificationsDTO selectByPrimaryKey(String uuid);

    int updateByExampleSelective(@Param("record") NotificationsDTO record, @Param("example") NotificationsDTOExample example);

    int updateByExample(@Param("record") NotificationsDTO record, @Param("example") NotificationsDTOExample example);

    int updateByPrimaryKeySelective(NotificationsDTO record);

    int updateByPrimaryKey(NotificationsDTO record);
}