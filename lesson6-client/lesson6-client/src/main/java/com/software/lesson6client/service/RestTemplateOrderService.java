package com.software.lesson6client.service;

import com.software.lesson6client.config.OrderServiceConfig;
import com.software.lesson6client.entity.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service("restTemplateOrderService")
public class RestTemplateOrderService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderServiceConfig orderServiceConfig;

    /**
     * 根据订单id获取订单详细信息
     * @param orderId
     * @return
     */
    public OrderEntity getOrderDetailInfoById(Integer orderId){
        //拼接调用订单服务请求url
        String requestUrl = String.format(orderServiceConfig.getOrderServiceUrl() +
                "/order/getOrderDetailInfoById?orderId={1}");
        //利用restTemplate实例调用订单服务
        return restTemplate.getForObject(requestUrl,OrderEntity.class,orderId);
    }
}
