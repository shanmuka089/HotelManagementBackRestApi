package com.example.demo.controllers;

import java.time.LocalDate;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.globalHandlr.SuccessResponse;
import com.example.demo.models.CustomersDetailsModel;
import com.example.demo.services.CustomerService;

@RestController
@RequestMapping("/com.htm")
public class CustomerDetailsController {
	
	static Logger log=LogManager.getLogger(CustomerDetailsController.class);
	
	@Autowired
	private CustomerService service;
	
	@GetMapping("/customers")
	public ResponseEntity<List<CustomersDetailsModel>> getCustomers(){
		List<CustomersDetailsModel> custList=service.getAllCustomers();
		log.info("get all customers using our application");
		return new ResponseEntity<List<CustomersDetailsModel>>(custList,HttpStatus.OK);
	}
	
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<SuccessResponse> deleteCustomer(@PathVariable("id") int id){
		service.deleteCustomerById(id);
		log.info("delete customer with respective to id has "+id);
		SuccessResponse response=new SuccessResponse(HttpStatus.OK.value(),"deleted success",LocalDate.now());
		return new ResponseEntity<>(response,HttpStatus.OK);
	}

}
