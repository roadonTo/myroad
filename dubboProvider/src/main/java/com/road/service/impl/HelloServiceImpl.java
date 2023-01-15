package com.road.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.road.service.HelloService;


@Service
public class HelloServiceImpl implements HelloService {


    public String sayHello(String name) {
        return "sakura" + name;
    }


}
