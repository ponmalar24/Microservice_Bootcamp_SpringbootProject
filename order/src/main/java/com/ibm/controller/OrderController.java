package com.ibm.controller;

import java.net.URISyntaxException;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.model.Order;

@CrossOrigin
@RestController
@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	Order order;
	
	@Autowired
	private RestTemplate restTemplate;
	
	private String url;
	
	@GetMapping
	public Order placeOrder() throws URISyntaxException  {
		
		ResponseEntity<Order> responseEntity=new RestTemplate().getForEntity(order.getUrl(), Order.class);	        
		restTemplate.exchange(url,
		                    HttpMethod.GET, null, new ParameterizedTypeReference<List<Order>>() {
		            });
		Order orders = responseEntity.getBody();
		return orders;
	}
	
	@GetMapping("/success")
	public String sucessMessage() {
		return "success";
	}
	
	
}
