package com.ibm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.ibm.model.MyHello;

@SpringBootApplication
public class HelloApplication implements CommandLineRunner{

	@Autowired
	MyHello mybean;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(HelloApplication.class, args);
		System.out.println("Number of Beans:"+ context.getBeanDefinitionCount());
		System.out.println("==========Beans=========");
		for (String bean : context.getBeanDefinitionNames()) {
			System.out.println(bean);
		}	
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" Printing : "+ mybean.getMessage());
		
	}
}

