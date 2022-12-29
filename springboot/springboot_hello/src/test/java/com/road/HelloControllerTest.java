package com.road;

import com.road.controller.HelloController;
import com.road.domain.User;
import com.road.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
//@SpringBootTest(classes = HelloApplication.class)  //指定启动类，如果测试类与启动类的目录结构不同的话
//@RunWith(SpringRunner.class)
public class HelloControllerTest {

    @Autowired
    private HelloController helloController;
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test(){
        System.out.println(helloController);

    }

    @Test
    public void testMybatis(){
        List<User> userList = userMapper.findAll();
        userList.forEach(System.out::println);
    }



}
