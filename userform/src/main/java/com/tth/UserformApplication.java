package com.tth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.tth.model.User;
import com.tth.service.UserService;

@SpringBootApplication
public class UserformApplication implements CommandLineRunner {
	
	@Autowired
	UserService userService;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	public static void main(String[] args)  {
		SpringApplication.run(UserformApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		userService.addUserRecord(new User("Anu","chennai"));
		userService.addUserRecord(new User("saffd","bangalore"));
	}

}
