package com.shoppingapp.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.login.model.CustomerData;
import com.shoppingapp.login.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	@Override
	public CustomerData register(CustomerData customerData) {
		return customerRepository.save(customerData);
	}

	@Override
	public CustomerData login(CustomerData customerData) throws Exception {
		 Optional<CustomerData> repoOptionalCustomer = customerRepository.findByloginId(customerData.getLoginId());
	        if(repoOptionalCustomer.isPresent()){
	        	CustomerData repoCustomer = repoOptionalCustomer.get();
	            if(repoCustomer.getPassword().equals(customerData.getPassword())){
	                return repoCustomer;
	            }
	            else{

	                throw new Exception("Incorrect Password");
	            }
	        }
	        else{
	            throw new Exception("No user found with provided email");
	        }

	}

	@Override
	public CustomerData forgotPassword(CustomerData customerData) throws Exception {
		 Optional<CustomerData> repoOptionalCustomer = customerRepository.findByloginId(customerData.getLoginId());
	        if(repoOptionalCustomer.isPresent()){
	        	CustomerData repoCustomer = repoOptionalCustomer.get();
	            repoCustomer.setPassword(customerData.getPassword());
	            return customerRepository.save(repoCustomer);
	        }
	        else{
	            throw new Exception("No user found with provided email");
	        }
	    }
	}

