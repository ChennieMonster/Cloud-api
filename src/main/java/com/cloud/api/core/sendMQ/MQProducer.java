package com.cloud.api.core.sendMQ;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.stereotype.Component;

import com.cloud.api.core.constant.Constants;
import com.cloud.api.entity.MqMessage;
import com.cloud.api.util.IdGen;

/**
 * 描述: 默认的交换机模式
 *
 * @author: zhang.feng
 * @create: 2017/10/25 1:03
 */
@Component
public class MQProducer {

	private static final Logger logger = LoggerFactory.getLogger(MQProducer.class);

	@Resource
	private RabbitTemplate rabbitTemplate;

	public void sendData(MqMessage msg, String kind) {

		String routeKey = kind;

		String exchange = Constants.MQ_EXCHANE_DIRECT;

		logger.info("====sendMq exchange:" + exchange + ",routeKey:" + routeKey);

		CorrelationData correlationData = new CorrelationData(IdGen.uuid());
		try {
			rabbitTemplate.convertAndSend(exchange, routeKey, msg, correlationData);
		} catch (NullPointerException e) {
			logger.warn(e.toString());
		}

	}

}