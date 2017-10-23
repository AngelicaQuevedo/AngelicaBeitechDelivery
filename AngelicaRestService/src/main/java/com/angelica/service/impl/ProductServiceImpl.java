package com.angelica.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angelica.dao.ProductDao;
import com.angelica.model.Product;
import com.angelica.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> getAllowedProductsByCustomer(Long customerId) {
        return productDao.getAllowedProductsByCustomer(customerId);
    }

}
