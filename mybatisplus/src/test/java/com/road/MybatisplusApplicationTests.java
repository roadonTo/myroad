package com.road;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.road.domain.User;
import com.road.mapper.UserMapper;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisplusApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testQueryList() {
        List<User> users = userMapper.selectList(null);
        System.out.println(users);
    }


    @Test
    public void testQueryWrapper(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name","kangkang");
        userQueryWrapper.ge("age",18);
        //select * from user where name = 'kangkang' and age > 18
        User user = userMapper.selectOne(userQueryWrapper);
        System.out.println(user);

    }



    @Test
    public void testPage(){
        Page<User> page = new Page<>(1,5);
        Page<User> userPage = userMapper.selectPage(page, null);
        List<User> userList = userPage.getRecords();
        userList.forEach(System.out::println);
        System.out.println("总记录数" + page.getTotal());
        System.out.println("当前页" + page.getCurrent());

    }

}
