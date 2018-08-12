package com.software.lesson6client.service;

import com.software.lesson6client.entity.OrderEntity;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


//其中order-service表示订单服务名称
@FeignClient(name = "order-service",path = "/order")
public interface FeignOrderService {

    /**
     * 对订单服务的请求uri为@FeignClient注解path属相与@RequestMapping
     * 属性的连接/order/getOrderDetailInfoById
     * @param orderId
     * @return
     */
    @RequestMapping("/getOrderDetailInfoById")
    OrderEntity getOrderDetailInfoById(@RequestParam(value = "orderId") Integer orderId);
}
