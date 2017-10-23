package com.angelica.webservice.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelica.model.Product;
import com.angelica.service.ProductService;
import com.angelica.webservice.restapi.common.BaseResponse;

@RestController
public class ProductRestController {
	
    @Autowired
    ProductService productService;
	
    @RequestMapping(value = "/GetAllowedProductsByCustomer/{id}", method = RequestMethod.GET)
    public AllowedProductsResponse getAllowedProductsByCustomer(@PathVariable("id") Long customerId) {
    	AllowedProductsResponse response = new AllowedProductsResponse();
        try {
            response.returnCode = 0;
            response.returnMessage = "success";
            response.customerId = customerId;
            response.products = productService.getAllowedProductsByCustomer(customerId);
        } catch (Exception e) {
            response.returnCode = 1;
            response.returnMessage = "Exception retrieving the products for the customer ";
            response.customerId = customerId;
        }

        return response;
    }
    
    class AllowedProductsRequest{
    	public Long customerId;
    }
	
	class AllowedProductsResponse extends BaseResponse {
        public Long customerId;
		public List<Product> products;
    }

}
