package com.bezkoder.spring.security.login;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootSecurityLoginApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSecurityLoginApplication.class, args);
	}
	
	  @Override
	    public void run(String... args) throws Exception {
	        roleRepository.save(new Role(ERole.ROLE_USER));
	        catalogRepository.save(new Catalog("item1", 10.0));
	        catalogRepository.save(new Catalog("item2", 5.0));
	        catalogRepository.save(new Catalog("item3", 11.0));
	        catalogRepository.save(new Catalog("item4", 20.0));
	    }

}
