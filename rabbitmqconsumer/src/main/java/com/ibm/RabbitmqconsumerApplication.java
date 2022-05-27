package com.ibm;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqconsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitmqconsumerApplication.class, args);
	}

	@RabbitListener(queues = "task")
	public void consume(String message)
	{
		System.out.println("=========****=========");
		System.out.println(message);
		System.out.println("=========****=========");
		
	}
}
