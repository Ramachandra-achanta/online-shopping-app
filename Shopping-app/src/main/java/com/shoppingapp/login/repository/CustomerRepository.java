package com.shoppingapp.login.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.shoppingapp.login.model.CustomerData;

public interface CustomerRepository extends MongoRepository<CustomerData, String> {
	@Query("{'loginId': ?0}")
    Optional<CustomerData> findByloginId(String loginId);

}
