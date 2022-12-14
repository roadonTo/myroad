package road.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("/")
    public String toIndex(){
        return "index";   //返回逻辑视图名称index，搭配上前缀后缀就是 /WEB-INF/templates/index.html
    }

    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }




}
