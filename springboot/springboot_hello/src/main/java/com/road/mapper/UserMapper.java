package com.road.mapper;

import com.road.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Mapper  //指定这个是mapper接口，不然mybatis不知道
@Repository
public interface UserMapper {

   public List<User> findAll();

}
