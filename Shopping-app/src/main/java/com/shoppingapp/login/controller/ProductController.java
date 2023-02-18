package com.shoppingapp.login.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping("/api/v1.0/ shopping /all")
	public void getAllProducts() {
		
	}
	
	@GetMapping("/api/v/1.0/shopping/products/search/productname")
	public void getProductByName() {
		
	}
	
	@PostMapping("/api/v1.0/ shopping /<productname>/add")
	public void addProduct() {
		
	}
	
	@PutMapping("/api/v1.0/shopping /<productname>/update/<id>")
	public void updateproductbyId() {
		
	}
	
	
	@DeleteMapping("/api/v1.0/ shopping /<productname>/delete/<id>")
	public void deleteProduct() {
		
	}
}
