package road.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import road.pojo.User;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestParamController {


    /**
     * 1. 通过servlet中的 HttpServletRequest来接收请求中的参数
     * @param request
     * @return
     */
    @RequestMapping("/test/servletAPI")
    public String servletAPI(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println( "username:" + username + ",password:" + password);
        return "success";
    }


    /**
     * 2. SpringMVC自带的效果，形参名与请求参数名一致就行
     * @param username
     * @param password
     * @return
     */
    @RequestMapping("/param1")
    public String getParam(String username, String password){
        System.out.println("username:" + username + ",password:" + password);
        return "success";
    }


    /**
     * 3. 使用@RequestParam()注解
     * RequestParam有三个参数：value  required  defaultValue
     * value 与要接收的参数名对应，表示接收这个参数的值
     * required 默认为true 表示必须得传这个参数过来，否则报错
     * defaultValue 当 required = false且又没有传参数过来时，  可以给这个形参设置一个默认值
     *
     *
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/param2")
    public String getParam2(
            @RequestParam(value = "username", required = false, defaultValue = "hello") String name,
            @RequestParam("password") String pwd){
        System.out.println("username:" + name + ",password:" + pwd);
        return "success";
    }


    /**
     *可以指定获取请求头中的信息，和 cookie中的信息
     * @param referer
     * @param jsessionid
     * @return
     */
    @RequestMapping("/getRequestHeaderAndCookie")
    public String getRequestHeaderAndCookie(
            @RequestHeader("referer") String referer,
            @CookieValue("JSESSIONID") String jsessionid){
        System.out.println("referer:" + referer );
        System.out.println("jsessionid:" + jsessionid );
        return "success";
    }

    /**
     * 4. 通过实体类型 来获取请求参数
     * 不用加任何注解，但需要实体类中的属性名与参数名一致
     * @param user
     * @return
     */
    @RequestMapping("/param3")
    public String getParam3(User user){
        System.out.println(user);
        return "success";
    }


}
