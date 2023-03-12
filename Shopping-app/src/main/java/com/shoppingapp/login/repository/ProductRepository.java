package com.shoppingapp.login.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.shoppingapp.login.model.ProductData;

public interface ProductRepository extends MongoRepository<ProductData, String> {
	@Query("{'productName': ?0}")
    Optional<ProductData> findByName(String productName);
	
	@Query(value = "{'productName': ?0}", delete = true)
    Optional<ProductData> deleteByName(String productName);
	
	@Query(value = "{'productName': ?0}", count = true)
    long countProducts(String productName);
	
}
