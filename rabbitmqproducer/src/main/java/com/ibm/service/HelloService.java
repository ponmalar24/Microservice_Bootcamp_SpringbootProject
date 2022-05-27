package com.ibm.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {

	
	@Autowired
	RabbitTemplate rabbitTemplate;
	
	public void publish(String queuename, String message )
	{
		rabbitTemplate.convertAndSend(queuename, message);
	}
}
