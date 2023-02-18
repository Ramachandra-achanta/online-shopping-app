package com.shoppingapp.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.login.model.CustomerData;
import com.shoppingapp.login.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class LoginController {
	
	@Autowired
	CustomerService customerService;

	@PostMapping("/shopping/register")
	public ResponseEntity<CustomerData> CustomerRegister(@RequestBody CustomerData customerData) {
		CustomerData response =  customerService.register(customerData);
		ResponseEntity<CustomerData> responseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
        return responseEntity;
	}
	
//	@GetMapping("/all")
//    public ResponseEntity<CustomerData> getAllProducts(){
//		CustomerData customerData = new CustomerData();
//		customerData.setFirstName("Rama");
//		customerData.setLastName("Chandra");
//		customerData.setLoginId("ramach-a");
//		customerData.setEmail("ach@gmail.com");
//		customerData.setContactNumber("7013487808");
//		customerData.setPassword("ram");
//		customerData.setConfirmpassword("ram");
//        return new ResponseEntity<>(customerData, HttpStatus.OK);
//    }

	@PostMapping("/shopping /login")
	public ResponseEntity<CustomerData> customerLogin(@RequestBody CustomerData customerData) throws Exception {
		CustomerData response =  customerService.login(customerData);
		ResponseEntity<CustomerData> responseEntity = new ResponseEntity<>(response, HttpStatus.CREATED);
        return responseEntity;
	}

	@GetMapping("/shopping/forgot")
	public ResponseEntity<CustomerData> forgetPassword(@RequestBody CustomerData customerData) throws Exception {
		CustomerData response = customerService.forgotPassword(customerData);
		ResponseEntity<CustomerData> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
        return responseEntity;

	}

}
