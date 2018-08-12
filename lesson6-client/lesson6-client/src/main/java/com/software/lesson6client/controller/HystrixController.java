package com.software.lesson6client.controller;


import com.software.lesson6client.entity.OrderEntity;
import com.software.lesson6client.service.HystrixOrderService;
import com.software.lesson6client.service.RestTemplateOrderService;
import org.omg.PortableInterceptor.ObjectReferenceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hystrixApi")
public class HystrixController {
    @Autowired
    private HystrixOrderService hystrixOrderService;

    @GetMapping("/getHystrixOrderDetailInfoById")
    public OrderEntity getOrderDetailInfoById(Integer orderId){
        return hystrixOrderService.getHystrixOrderDetailInfoById(orderId);
    }
}
