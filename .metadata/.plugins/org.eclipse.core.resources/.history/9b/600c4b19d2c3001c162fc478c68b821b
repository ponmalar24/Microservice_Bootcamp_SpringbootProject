package com.ibm.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ibm.model.Cart;
import com.ibm.model.Product;
import com.ibm.service.CartService;
import com.ibm.service.ProductService;

@CrossOrigin(origins = "http://localhost:8080")
@Controller
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	CartService cartService;
	
	@GetMapping
	public String getAllProduct(Model model){
		model.addAttribute("product", productService.getAllProduct());
		return "product";
		//return productService.getAllProduct();
	}
	
	@GetMapping("/addproduct")
	public String addProduct(Model model){
		Product product = new Product();
		model.addAttribute("product", product);
		return "addproduct";
		//return productService.getAllProduct();
	}
	
	@GetMapping("/cart")
	public String getCart(Model model){
		model.addAttribute("cart", cartService.getAllProduct());
		return "success";
	}
	
	@GetMapping("/cart/order")
	public String getOrder(Model model){
		return "order";
	}
	
	@GetMapping("{id}")
	public Product getById(@PathVariable int id)
	{
		return productService.getProductById(id);
	}
	
	@GetMapping("/productname/{productname}")
	public Product getProductById(@PathVariable String productname)
	{
		return productService.getProductByname(productname);
	}
	
	 @PostMapping("/saveproduct")
	    public String saveProduct(@ModelAttribute("product") Product product) {
	        productService.addProduct(product);
	        return "redirect:/product";
	    }

	 @PostMapping("/savecart")
	    public String saveProduct(@Valid @ModelAttribute("cart")Cart cart, 
	    	      BindingResult result, ModelMap model) 
	    {
		 System.out.println("Cart =>"+cart.toString());
		 if (result.hasErrors()) {
	            return "error";
	        }
	        model.addAttribute("id", cart.getId());
	        model.addAttribute("productname", cart.getProductname());
	        model.addAttribute("catagory", cart.getCatagory());
	        model.addAttribute("price",cart.getPrice());
		 
	        return "success";
		 
		 /*
			 * model.addAttribute("cart", new Cart()); return "redirect:/product";
			 */
	    }
	 
	 
	  @GetMapping("/showFormForUpdate/{id}")
	    public String updateProduct(@PathVariable(value = "id") int id, Model model) {
	        Product product = productService.getProductById(id);
	        model.addAttribute("product", product);
	        return "update";
	    }
	  
	    @GetMapping("/deleteProduct/{id}")
	    public String deleteThroughId(@PathVariable(value = "id") int id) {
	        productService.deleteById(id);
	        return "redirect:/product";
	  
	    }
	/*
	 * @PostMapping public ResponseEntity<Product>
	 * addConversionFactor(@Valid @RequestBody Product product) { Product result =
	 * productService.addProduct(product); URI location =
	 * ServletUriComponentsBuilder .fromCurrentRequest() .path("/{id}")
	 * .buildAndExpand(result.getId()).toUri(); return
	 * ResponseEntity.created(location) .body(result);
	 * 
	 * }
	 */
	
	@PutMapping("{id}")
	public ResponseEntity<Product> updateConverionFactor(@PathVariable int id, @Valid @RequestBody Product product )
	{
		Product result = productService.updateProduct(product);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("{id}")
				.buildAndExpand(result.getId()).toUri();
				return ResponseEntity.created(location)
						.body(result);
	}
}
