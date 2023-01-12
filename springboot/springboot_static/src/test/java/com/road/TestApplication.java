package com.road;

import com.road.controller.StaticController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestApplication {

    @Autowired
    private StaticController staticController;

    @Test
    public String test(){

        return "hello springboot_web";
    }


}
