package com.ibm.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest {
	
	@Autowired
	MockMvc mock;
	
//	@Test //unit testing 
//	public void testHelloByName()
//	{
//		RestTemplate rt = new RestTemplate();
//		
//		String result = rt.getForObject("http://localhost:9000/hello/Vikram", String.class);
//		System.out.println(result);
//		assertEquals(result, "Hello vikram");
//	}
	
	@Test  //mock testing
	public void testHelloByName() throws Exception
	{
		mock.perform(MockMvcRequestBuilders.get("/hello/Vikram"))
		.andExpect(status().isOk())
		.andExpect(content().string("Hello Vikram"));
	}

	@Test  //mock testing
	public void testNotFound() throws Exception
	{
		mock.perform(MockMvcRequestBuilders.get("/hello123"))
		.andExpect(status().isNotFound());
	}

}
