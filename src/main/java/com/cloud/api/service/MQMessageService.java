package com.cloud.api.service;

import com.cloud.api.entity.MqMessage;

/**
* @author huang_kefei
* @date 2018年10月23日
* 类说明
*/
public interface MQMessageService {
	
	boolean sendMqMessage(MqMessage mqMessage) ;

}
