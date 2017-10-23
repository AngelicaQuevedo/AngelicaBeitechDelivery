package com.angelica.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angelica.dao.CustomerDao;
import com.angelica.model.Customer;
import com.angelica.service.CustomerService;


@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerDao customerDao;

    @Override
    public Customer getCustomerbyId(Integer customerId) {
        return customerDao.findCustomerById(customerId);
    }

    @Override
    public List<Customer> getAllCustomers() {
    	return customerDao.findAllCustomers();
    }

}
