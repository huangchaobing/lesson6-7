package com.software.lesson6client.controller;

import com.software.lesson6client.entity.OrderEntity;
import com.software.lesson6client.service.FeignOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/feignApi")
public class FeignController {
    @Autowired
    private FeignOrderService feignOrderService;

    @GetMapping("/getOrderDetailInfoById")
    public OrderEntity getOrderDetailInfoById(Integer orderId) {
        return feignOrderService.getOrderDetailInfoById(orderId);
    }
}
