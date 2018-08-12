package com.software.lesson6client.entity;

import java.math.BigDecimal;

/**
 * 订单实体类
 */
public class OrderEntity {
    private int orderId;
    private String orderName;
    private BigDecimal totalPrice;

    public OrderEntity() {
    }

    public OrderEntity(int orderId, String orderName, BigDecimal totalPrice) {
        this.orderId = orderId;
        this.orderName = orderName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
