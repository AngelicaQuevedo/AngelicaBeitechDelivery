package com.angelica.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.angelica.dao.AbstractDao;
import com.angelica.dao.ProductDao;
import com.angelica.model.Product;

@Repository("productDao")
public class ProductDaoImpl extends AbstractDao<Integer, Product> implements ProductDao {

    @Override
    public List<Product> getAllowedProductsByCustomer(Long customerId) {
        Query query = getSession()
                .createSQLQuery(
                        "select prod.product_id AS 'productId', prod.name, prod.description, prod.creation_date as 'creationDate', prod.price, prod.category_id as 'categoryId' from allowed_product_customer apc inner join product prod ON prod.product_id = apc.product_id inner join customer cust on cust.customer_id = apc.customer_id where apc.customer_id = :customerId")
                .setResultTransformer(Transformers.aliasToBean(Product.class));
        query.setLong("customerId", customerId);
        List<Product> allowedProducts = query.list();
        return allowedProducts;
    }

}
