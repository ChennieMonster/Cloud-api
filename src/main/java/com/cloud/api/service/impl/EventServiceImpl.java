package com.cloud.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cloud.api.core.service.BaseService;
import com.cloud.api.dto.PodDTO;
import com.cloud.api.entity.EventDO;
import com.cloud.api.entity.MetaDataDO;
import com.cloud.api.entity.TokenDO;
import com.cloud.api.mapper.PodMapper;
import com.cloud.api.service.EventService;
import com.cloud.api.util.JsonUtils;

@Service
@Transactional
public class EventServiceImpl extends BaseService  implements EventService {
	
	@Resource
	private PodMapper podMapper;
	
	@Override
	public List<EventDO> getPodEvents(String podId, TokenDO token) {
		PodDTO podDTO = podMapper.selectByPrimaryKey(podId);
		MetaDataDO metaData = JsonUtils.jsonToObject(podDTO.getMetaData(), MetaDataDO.class);
		String uid = metaData.getUid();
		String podName = podDTO.getName();
		String nameSpace = metaData.getNamespace();
		
		String url = "/api/v1/namespaces/" + nameSpace + "/events?fieldSelector=involvedObject.namespace%3D" + nameSpace + "%2CinvolvedObject.uid%3D" + uid + "%2CinvolvedObject.name%3D" + podName;
		Invocation<EventDO> invocationPod = get(EventDO.class, url, token);
		CloseableHttpResponse response = invocationPod.executeWithResponseNotClose();
		String responseStr = "";
		try {
			responseStr = EntityUtils.toString(response.getEntity());
			response.close();
			JSONArray jsonArray = JSONObject.parseObject(responseStr).getJSONArray("items");
			List<EventDO> eventList = new ArrayList<EventDO>();
			for (Object object : jsonArray) {
				JSONObject obj = (JSONObject)object;
				EventDO eventDO = new EventDO();
				eventDO.setName(obj.getJSONObject("metadata").getString("name"));
				eventDO.setType(obj.getString("type"));
				eventDO.setReason(obj.getString("reason"));
				eventDO.setMessage(obj.getString("message"));
				eventDO.setFirstTime(obj.getDate("firstTimestamp"));
				eventDO.setLastTime(obj.getDate("lastTimestamp"));
				eventList.add(eventDO);
			}
			return eventList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
