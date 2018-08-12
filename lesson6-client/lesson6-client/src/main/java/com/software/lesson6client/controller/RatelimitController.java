package com.software.lesson6client.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rateApi")
public class RatelimitController {
    @RequestMapping("/getRatelimitInfo")
    public String getRatelimit(){
        return "test ratelimit";
    }
}
