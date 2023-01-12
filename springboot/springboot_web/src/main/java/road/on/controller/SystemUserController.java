package road.on.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import road.on.domain.ResponseResult;
import road.on.domain.SystemUser;
import road.on.domain.User;
import road.on.service.SystemUserService;
import road.on.utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/sys_user")
public class SystemUserController {
    @Autowired
    private SystemUserService userService;

    @PostMapping("/login")
    public ResponseResult login(@RequestBody SystemUser user) {

        //校验用户名密码是否正确
        SystemUser loginUser = userService.login(user);
        Map<String, Object> map;
        if (loginUser != null) {
            //如果正确 生成token返回
            map = new HashMap<>();
            String token = JwtUtil.createJWT(UUID.randomUUID().toString(), String.valueOf(loginUser.getId()), null);
            map.put("token", token);
        } else {
            //如果不正确 给出相应的提示
            return new ResponseResult(300, "用户名或密码错误，请重新登录");
        }
        return new ResponseResult(200, "登录成功", map);
    }
}
