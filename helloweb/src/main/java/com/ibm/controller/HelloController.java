package com.ibm.controller;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.model.Hello;

@RestController
public class HelloController {
	
	@GetMapping("hello")
	public String sayHello()
	{
		return "Hello World!!";
	}

	
	@GetMapping("hellobymessage")
	public String sayHelloByMessage(@RequestParam String message)
	{
		return "Hi "+message;
	}

	@GetMapping("hello/{name}")
	public String sayHelloByName(@PathVariable String name)
	{
		return "Hello "+name;
	}

@GetMapping("helloobj")
public Hello sayHelloObject()
{
	return new Hello("Hi IBM", new Date());
}


}