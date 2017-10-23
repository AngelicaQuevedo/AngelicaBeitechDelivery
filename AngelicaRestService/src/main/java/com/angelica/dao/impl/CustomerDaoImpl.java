package com.angelica.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.angelica.dao.AbstractDao;
import com.angelica.dao.CustomerDao;
import com.angelica.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl extends AbstractDao<Integer, Customer> implements CustomerDao {

    public Customer findCustomerById(Integer customerId) {
        return getByKey(customerId);
    }

    @SuppressWarnings("unchecked")
    public List<Customer> findAllCustomers() {
        Query query = getSession().createSQLQuery("select customer_id as \"customerId\", name, email from customer").setResultTransformer(Transformers.aliasToBean(Customer.class));
        List<Customer> customers = query.list();
        return customers;
    }

}
