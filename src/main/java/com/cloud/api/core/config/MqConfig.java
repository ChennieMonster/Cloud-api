package com.cloud.api.core.config;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cloud.api.util.IdGen;

/**
 * 描述: 配置默认的交换机模式
 *
 * Direct Exchange是RabbitMQ默认的交换机模式，也是最简单的模式，根据key全文匹配去寻找队列。
 *
 * @author zhang.feng
 * @create 2018-9-14 12:09
 **/
@Configuration
public class MqConfig {

	private static final Logger log = LoggerFactory.getLogger(MqConfig.class);

	@Resource
	private RabbitTemplate rabbitTemplate;

	@Bean
	public AmqpTemplate amqpTemplate() {
//	          使用jackson 消息转换器
		rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
		rabbitTemplate.setEncoding("UTF-8");
//	        开启returncallback     yml 需要 配置    publisher-returns: true
		rabbitTemplate.setMandatory(true);
		rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
			String correlationId = IdGen.uuid();
			log.debug("消息：{} 发送失败, 应答码：{} 原因：{} 交换机: {}  路由键: {}", correlationId, replyCode, replyText, exchange,
					routingKey);
		});
		// 消息确认 yml 需要配置 publisher-returns: true
		rabbitTemplate.setConfirmCallback((correlationData, ack, cause) -> {
			if (ack) {
				log.debug("消息发送到exchange成功");
			} else {
				log.debug("消息发送到exchange失败,原因: {}", cause);
			}
		});
		return rabbitTemplate;
	}
//	  @Bean
//	    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
//	        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
//	        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
//	        return rabbitTemplate;
//	    }
//
//	    @Bean
//	    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
//	        return new Jackson2JsonMessageConverter();
//	    }
//	

	@Bean
	public Queue deploymentQueue() {
		return new Queue("DEPLOYMENT_QUEUE");
	}

	@Bean
	public Queue serviceQueue() {
		return new Queue("SERVICE_QUEUE");
	}

	@Bean
	public Queue routeQueue() {
		return new Queue("ROUTE_QUEUE");
	}

	@Bean
	public Queue podQueue() {
		return new Queue("POD_QUEUE");
	}

	@Bean
	public Queue thirdRegistryQueue() {
		return new Queue("THIRDREGISTRY_QUEUE");
	}

	@Bean
	public Queue tagQueue() {
		return new Queue("TAG_QUEUE");
	}

	@Bean
	DirectExchange directExchange() {
		return new DirectExchange("DirectExchange");
	}

	@Bean
	Binding bindingExchangeDeploymentQueue(Queue deploymentQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(deploymentQueue).to(directExchange).with("Deployment");
	}

	@Bean
	Binding bindingExchangeServiceQueue(Queue serviceQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(serviceQueue).to(directExchange).with("Service");
	}

	@Bean
	Binding bindingExchangeRouteQueue(Queue routeQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(routeQueue).to(directExchange).with("Route");
	}

	@Bean
	Binding bindingExchangePodQueue(Queue podQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(podQueue).to(directExchange).with("Pod");
	}

	@Bean
	Binding bindingExchangeThirdRegistryQueue(Queue thirdRegistryQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(thirdRegistryQueue).to(directExchange).with("ThirdRegistry");
	}

	@Bean
	Binding bindingExchangeTagQueue(Queue tagQueue, DirectExchange directExchange) {
		return BindingBuilder.bind(tagQueue).to(directExchange).with("Tag");
	}
}
