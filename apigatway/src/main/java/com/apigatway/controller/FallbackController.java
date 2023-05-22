package com.apigatway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {
    @GetMapping("/userservicefallback")
    public String UserServiceFallback(){
        return "user service is down at this time !!!";
    }

    @GetMapping("/contactservicefallback")
    public String ContactServiceFallback(){
        return "contact service is down at this time !!!";
    }
}
