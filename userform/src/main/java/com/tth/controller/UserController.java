package com.tth.controller;


import java.util.Collections;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tth.model.City;
import com.tth.model.User;
import com.tth.repository.UserRepository;
import com.tth.service.UserService;

@CrossOrigin
@Controller
@RequestMapping("/population")
public class UserController {
	
	@Value("${populationurl}")
	private String url;
	
	@Autowired
	User user;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public List<User> getUSers() {
		return userService.getAllUsers();
	}
	
	@PostMapping("/user")
	public String addUSers(@ModelAttribute User user, Model model) {
		System.out.println(user.getName());
		System.out.println(user.getCity());
		User user_insert=userRepo.save(user);
		return null;
	}

	@GetMapping("{id}")
	public User getConversionFactorById(@PathVariable int id) {
		
		return userService.getUserById(id);
	}
	
	@GetMapping("/city/{city}")
	public List<User> getConversionFactorById(@PathVariable String city) {
		 	  
		  HttpHeaders headers = new HttpHeaders();
		  headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
		  headers.setContentType(MediaType.APPLICATION_JSON);
		  headers.add("x-api-key", "/WufMn0764cGBnpIGopEzw==hM63v5nN1KxTHWCu");
		 // headers.set("X-Api-Key", "/WufMn0764cGBnpIGopEzw==hM63v5nN1KxTHWCu");

		  HttpEntity<String> requestEntity = new HttpEntity<>(headers);
		  
		  ResponseEntity<City[]> response = restTemplate.exchange(
				  url+"?name="+city, HttpMethod.GET, requestEntity, City[].class);
		  City[] response1=response.getBody();
		  long population = response1[0].getPopulation();
		  List<User> newRecord = userService.getUserBycity(city);
		  newRecord.forEach(user-> {
			 user.setPopulation(population);
		  }
		  );
		  //Long x= newRecord.stream().mapToLong(User::getPopulation).sum();
		 userRepo.saveAllAndFlush(newRecord);
		 return newRecord;
	}


	@PostMapping
	public User addNewRecord(@RequestBody User user) {
		User result = userService.addUserRecord(user);
		return result;

	}
	
	@PutMapping("{id}")
	public User updateRecord(@PathVariable int id,
			 @RequestBody User population) {
		User result = userService.updateUserRecord(population);
		return result;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable int id)
	{
		 userService.deleteUser(id);
		 return ResponseEntity.noContent().build();
	}

	 
}
