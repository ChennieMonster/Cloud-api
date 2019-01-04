package com.cloud.api.service;

import java.util.List;

import com.cloud.api.entity.response.NotificationResponse;

public interface NotificationService {
	
	List<NotificationResponse> queryNotificationsAll();
	
	NotificationResponse queryNotificationsDetail(String id);
}
