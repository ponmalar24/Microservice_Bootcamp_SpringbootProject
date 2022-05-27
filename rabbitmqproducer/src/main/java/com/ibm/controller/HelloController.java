package com.ibm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.service.HelloService;

@RestController

public class HelloController {

	@Autowired
	HelloService helloService;
	
	@GetMapping
	public void publish(@RequestParam String queuename, @RequestParam String message)
	{		
		System.out.println(queuename);
		System.out.println(message);
		helloService.publish(queuename, message);
	}
}
