package com.software.lesson6client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceConfig {
    @Value("${order.service.url}")
    private String orderServiceUrl;

    public String getOrderServiceUrl() {
        return orderServiceUrl;
    }
}
