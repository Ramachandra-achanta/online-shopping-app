package com.shoppingapp.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.login.model.ProductData;
import com.shoppingapp.login.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping("/shopping/all")
	public ResponseEntity<List<ProductData>> getAllProducts() {
		return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
	}

	@GetMapping("/shopping/products/search/{productname}")
	public ResponseEntity<ProductData> getProductByName(@PathVariable String productname) throws Exception {
		return new ResponseEntity<>(productService.getProductsByName(productname), HttpStatus.OK);
	}

	@PostMapping("/shopping/productname/add")
	public ResponseEntity<ProductData> addProduct(@RequestBody ProductData productData) {
		return new ResponseEntity<>(productService.addProduct(productData), HttpStatus.OK);
	}

	@PutMapping("/shopping/update/{productname}")
	public ResponseEntity<ProductData> updateproductStatus(@RequestBody ProductData productData,
			@PathVariable String productname) throws Exception {
		return new ResponseEntity<>(productService.updateProductStatus(productname, productData.getProductStatus()),
				HttpStatus.OK);
	}

	@DeleteMapping("/shopping/delete/{productname}")
	public ResponseEntity<String> deleteProduct(@PathVariable String productname) {
		return new ResponseEntity<>(productService.deleteProduct(productname), HttpStatus.OK);
	}

}
