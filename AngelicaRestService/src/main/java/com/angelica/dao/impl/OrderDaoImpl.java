package com.angelica.dao.impl;

import org.springframework.stereotype.Repository;

import com.angelica.dao.AbstractDao;
import com.angelica.dao.OrderDao;
import com.angelica.model.Order;

@Repository("orderDao")
public class OrderDaoImpl extends AbstractDao<Integer, Order> implements OrderDao {

    @Override
    public void addNewCustomerOrder(Order order) {
        persist(order);
    }

}
