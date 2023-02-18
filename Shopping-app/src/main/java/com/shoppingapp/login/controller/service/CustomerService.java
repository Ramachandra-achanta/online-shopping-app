package com.shoppingapp.login.controller.service;

import com.shoppingapp.login.model.CustomerData;

public interface CustomerService {

	public CustomerData register(CustomerData customerData);
	public CustomerData login(CustomerData customerData) throws Exception;
	public CustomerData forgotPassword(CustomerData customerData) throws Exception;
	
}
