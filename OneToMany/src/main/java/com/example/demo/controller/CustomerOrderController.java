package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerOrderController {
	
	@Autowired
	CustomerService  cservice;
	
	@PostMapping("/")
	public ResponseEntity  createCustomer(@RequestBody Customer customer) {
		cservice.addCustomer(customer);
		return new  ResponseEntity(" Customer Added ", HttpStatus.CREATED);
	}
	
	@PostMapping("/{cId}/order")
	public ResponseEntity createOrder(@PathVariable("cId") int cId, @RequestBody  Orders order) {
		cservice.addOrder(cId, order);
		return new  ResponseEntity("Order Created", HttpStatus.OK);
	}

	@DeleteMapping("/{cId}")
	public ResponseEntity  deleteCustomer(@PathVariable("cId") int cId) {
		cservice.deleteCustomer(cId);
		return new ResponseEntity("Deleted", HttpStatus.OK);
	}
	
	@GetMapping("/{cId}/orders")
	public ResponseEntity<List<Orders>> getOrderForCustomer(@PathVariable("cId") int cId){
	         List<Orders> ordersForCustomer = cservice.getOrdersForCustomer(cId);
	         return new ResponseEntity(ordersForCustomer, HttpStatus.OK);
	}


}
