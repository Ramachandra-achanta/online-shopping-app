package com.shoppingapp.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.login.model.ProductData;
import com.shoppingapp.login.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public List<ProductData> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public ProductData getProductsByName(String name) throws Exception {
		Optional<ProductData> product = productRepository.findByName(name);
		if (product.isPresent()) {
			return product.get();
		} else {
			throw new Exception("No products found with provided name");
		}
	}

	@Override
	public ProductData addProduct(ProductData productData) {
		return productRepository.save(productData);
	}

	@Override
	public ProductData updateProductStatus(String name, String status) throws Exception {
		Optional<ProductData> optionalProduct = productRepository.findByName(name);
		if (optionalProduct.isPresent()) {
			ProductData product = optionalProduct.get();
			product.setProductStatus(status);
			return productRepository.save(product);
		} else {
			throw new Exception("No product found with provided name");
		}

	}

	@Override
	public String deleteProduct(String name) {
		productRepository.deleteById(name);
		return "Product successfully deleted";
	}

}
