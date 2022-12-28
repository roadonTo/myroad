package road.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 三种视图解析器
 * thymeleafView，直接被thymeleaf解析 加上前后缀
 * internalResourceView（很少用），这种相当于forword转发，但转发到的页面不会被thymeleaf解析 也就用不了thymeleaf语法
 * redirectView，重定向，SpringMVC中实现重定向的方式
 */

@Controller
public class TestViewController {


    @RequestMapping("/thymeleafView")
    public String test1() {
        return "success";
    }

    @RequestMapping("/internalResourceView")
    public String test2() {
        return "forword:/success";
    }


    @RequestMapping("/redirectView")
    public String test3() {
        return "redirect:/test/getParams";
    }


}
