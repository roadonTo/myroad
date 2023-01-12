package road.on.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import road.on.domain.ResponseResult;
import road.on.domain.User;
import road.on.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findAll")
//    @CrossOrigin  允许跨域
    public ResponseResult findAll(){
        //调用service查询数据，进行返回
        List<User> userList = userService.findAll();
        return new ResponseResult(200, userList);
    }




}
