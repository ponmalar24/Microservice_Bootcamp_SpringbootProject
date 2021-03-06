package com.ibm.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.Cart;
import com.ibm.repository.CartRepository;
import com.ibm.service.CartService;

@CrossOrigin
@RestController
@RequestMapping("/cart")
public class CartController {
	@Autowired
	CartService cartService;
	
	@GetMapping
	public List<Cart> getAllProduct(){
		return cartService.getAllProduct();
	}
	
	@PostMapping
	public ResponseEntity<Cart> addConversionFactor(@Valid @RequestBody Cart cart)	
	{
		Cart result = cartService.addProduct(cart);
		long price = cart.getQuantity()*cart.getPrice();
		cart.setPrice(price);
		URI location = ServletUriComponentsBuilder
		.fromCurrentRequest()
		.path("/{id}")
		.buildAndExpand(result.getId()).toUri();
		return ResponseEntity.created(location)
				.body(result);
		
	}

}
