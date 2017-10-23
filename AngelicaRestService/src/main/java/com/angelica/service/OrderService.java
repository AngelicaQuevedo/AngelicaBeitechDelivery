package com.angelica.service;

import java.util.List;

import com.angelica.webservice.restapi.wrapper.ProductDetail;

public interface OrderService {

    public void generateProductsOrder(Long customerId, String deliveryAddress, List<ProductDetail> productsToOrder);

}
