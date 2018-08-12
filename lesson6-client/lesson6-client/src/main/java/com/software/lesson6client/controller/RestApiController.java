package com.software.lesson6client.controller;

import com.software.lesson6client.entity.OrderEntity;
import com.software.lesson6client.service.RestTemplateOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restApi")
public class RestApiController {
    @Autowired
    private RestTemplateOrderService restTemplateOrderService;

    @GetMapping ("getOrderDetailInfoById")
    public OrderEntity getOrderDetailInfoById(Integer orderId){
        return restTemplateOrderService.getOrderDetailInfoById(orderId);
    }
}
