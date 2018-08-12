package com.software.lesson6client.service;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.software.lesson6client.config.OrderServiceConfig;
import com.software.lesson6client.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service("hystrixOrderService")
public class HystrixOrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderServiceConfig orderServiceConfig;

    /**
     * 根据订单id获取订单详细信息
     * @param orderId
     * @return
     */
    @HystrixCommand(fallbackMethod = "getDefaultOrderEntity")
    public OrderEntity getHystrixOrderDetailInfoById(Integer orderId){
        //拼接调用订单服务请求url
        String requestUrl = String.format(orderServiceConfig.getOrderServiceUrl() +
                "/order/getHystrixOrderDetailInfoById?orderId={1}");
        //利用restTemplate实例调用订单服务
        return restTemplate.getForObject(requestUrl,OrderEntity.class,orderId);
    }

    //服务降级方法，在实际生产中应该根据自身业务进行实现
    public OrderEntity getDefaultOrderEntity(Integer orderId){
        return new OrderEntity(orderId,"default",new BigDecimal(1000));
    }
}
