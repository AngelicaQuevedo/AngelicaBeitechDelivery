package com.angelica.webservice.restapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelica.model.Customer;
import com.angelica.service.CustomerService;
import com.angelica.webservice.restapi.common.BaseResponse;

@RestController
public class CustomerRestController {

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/GetCustomers", method = RequestMethod.GET)
    public CustomersResponse getCustomers() {
        CustomersResponse response = new CustomersResponse();
        try {
            response.customers = customerService.getAllCustomers();
            response.returnCode = 0;
            response.returnMessage = "success";
        } catch (Exception e) {
            response.returnCode = 1;
            response.returnMessage = "Exception retrieving the customers";
        }

        return response;
    }

    class CustomersResponse extends BaseResponse {
        public List<Customer> customers;
    }

}
