package com.road.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticController {

    @RequestMapping("/test")
    public String test(){
        return "test";
    }


}
