package com.cloud.api.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.core.sendMQ.MQProducer;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.service.MQMessageService;

/**
* @author huang_kefei
* @date 2018年10月23日
* 类说明
*/
@Service
public class MQMessageServiceImpl implements MQMessageService {
	private static final Logger logger = LoggerFactory.getLogger(MQMessageServiceImpl.class);
	
	@Autowired
	private MQProducer mqProducer ;
	
	@Override
	public boolean sendMqMessage(MqMessage mqMessage) {
		// TODO Auto-generated method stub
//		将token msg 组装成类，并转成json发送mq
//		logger.info("enter sendMqMessage service msg："+msg);
		String kind=mqMessage.getKind();
		try {
			if(Constants.MQ_ROUTEKEY_DEPLOYMENT.equals(kind)) {
				mqProducer.sendData(mqMessage,kind);
			}else if(Constants.MQ_ROUTEKEY_SERVICE.equals(kind)) {
				mqProducer.sendData(mqMessage,kind);
			}else if(Constants.MQ_ROUTEKEY_ROUTE.equals(kind)) {
				mqProducer.sendData(mqMessage,kind);
			}else if(Constants.MQ_ROUTEKEY_POD.equals(kind)) {
				mqProducer.sendData(mqMessage,kind);
			}else if(Constants.MQ_ROUTEKEY_REGISTRY.equals(kind)){
				mqProducer.sendData(mqMessage,kind);
			}else if(Constants.MQ_ROUTEKEY_TAG.equals(kind)){
				mqProducer.sendData(mqMessage,kind);
			}else if(Constants.MQ_ROUTEKEY_QUOTA.equals(kind)) {
				mqProducer.sendData(mqMessage,kind);
			}else if(Constants.MQ_ROUTEKEY_CONTAINER.equals(kind)) {
				mqProducer.sendData(mqMessage,kind);
			}
			else {
				logger.warn("no match kind!");
			}
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
