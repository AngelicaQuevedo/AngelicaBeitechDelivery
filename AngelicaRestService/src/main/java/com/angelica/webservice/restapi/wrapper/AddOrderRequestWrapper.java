package com.angelica.webservice.restapi.wrapper;

import java.util.List;


public class AddOrderRequestWrapper {

    public String customerId;
    public String deliveryAddress;
    public List<ProductDetail> productsToOrder;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public List<ProductDetail> getProductsToOrder() {
        return productsToOrder;
    }

    public void setProductsToOrder(List<ProductDetail> productsToOrder) {
        this.productsToOrder = productsToOrder;
    }

}
