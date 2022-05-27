package com.ibm;

import java.util.UUID;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.ibm.model.Todo;
import com.ibm.repository.TodoRepository;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner{
	@Autowired
	TodoRepository todoRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Todo todo = new Todo(UUID.randomUUID(), "malar", "Learn Spring boot", LocalDate.now(), false);
		todoRepo.save(todo);
		
	}
	
	  @Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Todo API")
	              .description("Todo sample application")
	              .version("v0.0.1")
	              .license(new License().name("Apache 2.0").url("http://springdoc.org")))
	              .externalDocs(new ExternalDocumentation()
	              .description("SpringShop Wiki Documentation")
	              .url("https://springshop.wiki.github.org/docs"));
	  }


}
