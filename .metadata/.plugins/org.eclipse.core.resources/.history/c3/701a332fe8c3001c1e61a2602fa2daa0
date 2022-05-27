package com.ibm;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.ibm.model.Cart;
import com.ibm.repository.CartRepository;
import com.ibm.service.CartService;

@SpringBootApplication
public class ProductApplication implements CommandLineRunner {

	@Autowired
	CartService cartService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		cartService.addProduct(new Cart(1, "Apple", "Fruit",100));
	}

}
