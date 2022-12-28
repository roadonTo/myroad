package com.road.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.road.domain.User;
import com.road.mapper.UserMapper;
import com.road.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

}
