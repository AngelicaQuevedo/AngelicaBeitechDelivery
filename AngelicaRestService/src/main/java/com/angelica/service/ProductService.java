package com.angelica.service;

import java.util.List;

import com.angelica.model.Product;

public interface ProductService {

    List<Product> getAllowedProductsByCustomer(Long customerId);

}
