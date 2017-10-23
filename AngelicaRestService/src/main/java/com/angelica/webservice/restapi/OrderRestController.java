package com.angelica.webservice.restapi;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.angelica.service.OrderService;
import com.angelica.webservice.restapi.common.BaseResponse;
import com.angelica.webservice.restapi.wrapper.AddOrderRequestWrapper;
import com.angelica.webservice.restapi.wrapper.ProductDetail;

@RestController
public class OrderRestController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/AddOrder/{id}", method = RequestMethod.POST)
    public AddOrderResponse addOrder(@RequestBody AddOrderRequestWrapper orderReq, @PathVariable("id") Long customerId) {
        AddOrderResponse response = new AddOrderResponse();
        try {

            List<ProductDetail> productsDetail = orderReq.getProductsToOrder().stream().collect(Collectors.toList());
            orderService.generateProductsOrder(customerId, orderReq.getDeliveryAddress(), productsDetail);

            response.returnCode = 0;
            response.returnMessage = "success";
            response.addOrderMessage = "order added for customer " + customerId;
        } catch (Exception e) {
            e.getMessage();
            response.returnCode = 1;
            response.returnMessage = "Exception during adding the order";
            response.addOrderMessage = "no order generated for customer " + customerId;
        }
        return response;
    }

    class AddOrderResponse extends BaseResponse {
        public String addOrderMessage;
    }


}
