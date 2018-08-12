package com.software.ratelimitServer.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratelimit")
public class RatelimitController {
    @RequestMapping("/getRatelimitInfo")
    public String getRatelimit(){
        System.out.println("enter ------");
        return "test ratelimit";
    }
}
