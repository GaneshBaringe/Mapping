package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;
import com.example.demo.repository.CustomerRepo;
import com.example.demo.repository.OrderRepo;
@Service
public class CustomerServiceImpl   implements CustomerService {

	@Autowired
	CustomerRepo crepo;
	
	@Autowired
	OrderRepo  orepo;
	
	
	@Override
	public void addCustomer(Customer customer) {
		 crepo.save(customer);
		
	}

	@Override
	public void addOrder(int cId,Orders order) {
		Customer customer= crepo.findById(cId).get();
		
            order.setCustomer(customer);
        
		orepo.save(order);
		  
		
	}

	@Override
	public void deleteCustomer(int cId) {
		crepo.deleteById(cId);
		
	}

	@Override
	public List<Orders> getOrdersForCustomer(int cId) {
		  Customer c=crepo.findById(cId).get();
		 List<Orders> orders =	c.getOrders();
		  
		  return orepo.saveAll(orders);
		
		  
	}

}
