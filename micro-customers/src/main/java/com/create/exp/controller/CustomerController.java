package com.create.exp.controller;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.create.exp.message.Customer;
import com.create.exp.message.CustomerRequest;
import com.create.exp.message.CustomerResponse;

@RestController
public class CustomerController {
	
	private static Logger logger = LogManager.getLogger(CustomerController.class);
	
	@GetMapping (value = "/api/v1/customers", produces=MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<CustomerResponse> getCustomers(@RequestBody CustomerRequest request){
		CustomerResponse response = new CustomerResponse();
		try {
			if(false) {
				throw new Exception("Thows From Service Error");
			}
			
			ArrayList dataCustomers = new ArrayList();
			
			Customer customer = new Customer();
			customer.setId("1");
			customer.setName("Heri");
			dataCustomers.add(customer);
			
			customer = new Customer();
			customer.setId("2");
			customer.setName("Heru");
			dataCustomers.add(customer);
			
			response.setDataList(dataCustomers);
		}catch(Exception e) {
			logger.error("Exception ", e);
		}
		
		return ResponseEntity.ok(response);
	}
	
	@GetMapping (value = "/api/v1/customers/{id}")
	public ResponseEntity<CustomerResponse> getCustomer(@PathVariable CustomerRequest request){
		CustomerResponse response = new CustomerResponse();
		try {

			if(request.getId() != null) {
				response.setId("1");
				response.setName("Heri");
			}else {
				throw new Exception("Customer Not Found");
			}
			
		}catch(Exception e) {
			logger.error("Exception ", e);
		}
		
		return ResponseEntity.ok(response);
	}
}
