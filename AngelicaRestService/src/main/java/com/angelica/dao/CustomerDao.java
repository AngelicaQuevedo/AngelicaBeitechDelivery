package com.angelica.dao;

import java.util.List;

import com.angelica.model.Customer;

public interface CustomerDao {
	
	Customer findCustomerById(Integer customerId);
	
	List<Customer> findAllCustomers();

}
