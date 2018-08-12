package com.software.lesson6.controller;

import com.software.lesson6.entity.OrderEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/order")
public class OrderController {
    /**
     * 获取订单详情接口
     * @param orderId
     * @return
     */
    @RequestMapping("/getOrderDetailInfoById")
    public OrderEntity getOrderDetailInfo(Integer orderId){
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderId(orderId);
        orderEntity.setOrderName("运动鞋");
        orderEntity.setTotalPrice(new BigDecimal(500));

        return orderEntity;
    }

    /**
     * 根据订单id获取订单信息
     * @param orderId
     * @return
     */
    @RequestMapping("/getHystrixOrderDetailInfoById")
    public OrderEntity getHystrixOrderDetailInfoById(Integer orderId){
        OrderEntity orderEntity = new OrderEntity();

        orderEntity.setOrderId(orderId);
        orderEntity.setOrderName("balabala婴儿鞋");
        orderEntity.setTotalPrice(new BigDecimal(100));

        //为了模拟熔断的效果，此处让当前线程停止运行5秒
        try {
            Thread.sleep(5000);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        return orderEntity;
    }
}
