package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Orders;

public interface CustomerService {
	
	public void addCustomer(Customer customer);
	public void addOrder(int cId, Orders order);
	public void deleteCustomer(int cId);
	public List<Orders> getOrdersForCustomer(int cId);
}
