package com.road.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.road.service.HelloService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class HelloController {

    @Reference
    private HelloService helloService;


    @RequestMapping("/hello")
    @ResponseBody
    public String testHello(String name){
       return helloService.sayHello(name);
    }


}
