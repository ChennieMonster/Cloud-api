package com.cloud.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloud.api.dto.NotificationsDTO;
import com.cloud.api.dto.NotificationsDTOExample;
import com.cloud.api.entity.response.NotificationResponse;
import com.cloud.api.mapper.NotificationsMapper;
import com.cloud.api.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Resource
	private NotificationsMapper notificationsMapper;
	
	@Override
	public List<NotificationResponse> queryNotificationsAll() {
		List<NotificationsDTO> notificationsList = notificationsMapper.selectByExample(new NotificationsDTOExample());
		List<NotificationResponse> notificationRequestList = new ArrayList<NotificationResponse>();
		for (NotificationsDTO notificationsDTO : notificationsList) {
			NotificationResponse response = new NotificationResponse();
			response.setNotificationName(notificationsDTO.getName());
			response.setCreatedTime(notificationsDTO.getCreatedTime());
			String[] array = notificationsDTO.getDescription().split(";");
			String monitorName = array[0].split(":")[1].trim();
			String monitorRule = array[1].split(":")[1].trim();
			String monitorObj = array[2].split(":")[1].trim();
			String value = array[3].split(":")[1].trim();
			response.setId(notificationsDTO.getUuid());
			response.setValue(value);
			response.setMonitorName(monitorName);
			response.setMonitorRule(monitorRule);
			response.setMonitorObj(monitorObj);
			notificationRequestList.add(response);
		}
		return notificationRequestList;
	}

	@Override
	public NotificationResponse queryNotificationsDetail(String id) {
		NotificationsDTO notifications = notificationsMapper.selectByPrimaryKey(id);
		NotificationResponse response = new NotificationResponse();
		response.setNotificationName(notifications.getName());
		response.setCreatedTime(notifications.getCreatedTime());
		String[] array = notifications.getDescription().split(";");
		String monitorName = array[0].split(":")[1].trim();
		String monitorRule = array[1].split(":")[1].trim();
		String monitorObj = array[2].split(":")[1].trim();
		String value = array[3].split(":")[1].trim();
		response.setId(notifications.getUuid());
		response.setValue(value);
		response.setMonitorName(monitorName);
		response.setMonitorRule(monitorRule);
		response.setMonitorObj(monitorObj);
		return response;
	}

}
