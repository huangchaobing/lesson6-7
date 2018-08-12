package com.software.lesson6client.controller;

import com.software.lesson6client.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/api")
@RestController
public class ApiController {
    @Autowired
    private LoadBalancerClient loadBalancer;

    @RequestMapping("/getOrderDetailInfoById")
    public Object getOrderDetailInfoById(Integer orderId) {
        //从注册中心获取订单服务order-service实例
        ServiceInstance serviceInstance = loadBalancer.choose("order-service");

        //拼接调用订单服务(order-service)接口url地址
        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort()
                + "/order/getOrderDetailInfoById?orderId={1}";

        //利用RestTemplate实例调用订单服务接口
        return new RestTemplate().getForObject(url, OrderEntity.class, 100);
    }
}
