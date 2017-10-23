package com.angelica.service.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angelica.dao.OrderDao;
import com.angelica.model.Order;
import com.angelica.model.OrderDetail;
import com.angelica.service.OrderService;
import com.angelica.webservice.restapi.wrapper.ProductDetail;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Override
    public void generateProductsOrder(Long customerId, String deliveryAddress, List<ProductDetail> productsToOrder) {

        Order order = new Order();
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetailItem;

        for (ProductDetail productDetail : productsToOrder) {
            orderDetailItem = new OrderDetail();
            orderDetailItem.setOrder(order);
            orderDetailItem.setProductId(productDetail.getProductId());
            orderDetailItem.setPrice(productDetail.getProductPrice());
            orderDetailItem.setDetailDescription(productDetail.getDescription());
            orderDetails.add(orderDetailItem);
        }

        order.setCreationDate(LocalDate.now());
        order.setCustomerId(customerId);
        order.setDeliveryAddress(deliveryAddress);
        order.setDeliveryDate(LocalDate.now().plusDays(5L));
        order.setTotal(5000F);
        order.setOrderDetails(orderDetails);

        // orderDao.addNewCustomerOrder(order);

    }

}
