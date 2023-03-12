package com.shoppingapp.login.service;

import java.util.List;

import com.shoppingapp.login.model.ProductData;

public interface ProductService {
	
	public List<ProductData> getAllProducts();
	public ProductData getProductsByName(String name) throws Exception;
	public ProductData addProduct(ProductData productData);
	public ProductData updateProductStatus(String name,String status) throws Exception;
	public String deleteProduct(String name);

}
