package com.angelica.service;

import java.util.List;

import com.angelica.model.Customer;

public interface CustomerService {

    public Customer getCustomerbyId(Integer customerId);

    public List<Customer> getAllCustomers();

}
