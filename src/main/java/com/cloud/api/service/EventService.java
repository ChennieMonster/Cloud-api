package com.cloud.api.service;

import java.util.List;

import com.cloud.api.entity.EventDO;
import com.cloud.api.entity.TokenDO;

public interface EventService {
	
	List<EventDO> getPodEvents(String podId, TokenDO token);
}
