package com.angelica.dao;

import java.util.List;

import com.angelica.model.Product;

public interface ProductDao {
	
	List<Product> getAllowedProductsByCustomer(Long customerId);

}
