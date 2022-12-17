package road.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 1. @RequestMapping注解标识的位置：类上（设置请求路径的初始信息），方法上（设置请求路径的具体信息）
 * 2. @RequestMapping注解的value属性：value属性是数组类型，可以匹配多个请求路径  value = {"/hello","/abc"}
 * 3. @RequestMapping注解的method属性：method属性也是数组类型，就表示可以设置多个，与浏览器发送请求的请求方式匹配
 *    method = {RequestMethod.POST, RequestMethod.GET}
 *    若浏览器发送的请求路径与@RequestMapping注解的value属性匹配 但请求方式不匹配，页面报错：405 - Request method 'xxx' not supported
 * 4. 结合请求方式的一些派生注解：@GetMapping,@PostMapping,@DeleteMapping,@PutMapping
 * 5. @RequestMapping注解的params属性：通过浏览器发送请求的 请求参数 匹配，
 *    params有四种设置方式： params = {"username","!password","age=20","gender!=女"}
 *    分别表示 参数中要携带有username属性，参数中不能携带有password属性，参数中必须携带有值等于20的age属性，参数中不能携带有值为女的gender属性
 *    若浏览器发送的请求路径 的请求方式和value值都匹配 但请求参数不匹配，页面报错： 400 - Parameter conditions "username" not met for actual request parameters
 * 6. @RequestMapping注解的headers属性：通过请求头信息匹配请求,
 *    即浏览器发送的请求的请求头信息必须满足headers属性的设置  headers = {"referer"} ，表示请求头中要包含有referer属性
 *    若浏览器发送的请求路径 的请求方式和value值都匹配 但请求头信息不匹配，页面报错：404
 *
 *
 * SpringMVC中 路径里面值的写法 和 路径中使用占位符来获取参数
 *    1. SpringMVC中 支持ant风格的路径，即：
 *      在@RequestMapping注解的value属性值中设置一些特殊字符
 *      ?:任意的单个字符（不包括?）
 *      *:任意个数的任意字符（不包括?和/）
 *      **:任意层数的任意目录，注意使用方式只能**写在双斜线中，前后不能有任何的其他字符以及空格
 *    例如：@RequestMapping("/a?c/ant"),,, @RequestMapping("/a*a"),,, @RequestMapping("/abc/ ** /")
 *    2. 路径中使用占位符，即：
 *      传统：/deleteUser?id=1
 *      rest：/user/delete/1    （这是前端浏览器传的url，1是传过来的值）
 *      后端接收：@RequestMapping("/user/delete/{id}")
 *      需要在@RequestMapping注解的value属性中所设置的路径中，使用{xxx}的方式表示路径中的数据
 *      在通过@PathVariable注解，将占位符所标识的值和控制器方法的形参进行绑定
 *    例如：@RequestMapping("/test/rest/{username}/{id}")
 *         public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username){
 *
 */



@Controller
//@RequestMapping("/test")
public class TestRequestMappingController {

    @RequestMapping("/")
    public String poral(){
        return "index";
    }


    //此时控制器方法所匹配的请求的请求路径为/test/hello
    @RequestMapping(
            value = {"/hello","/abc"},
            method = {RequestMethod.POST, RequestMethod.GET},
            //params = {"username","!password","age=20","gender!=女"},
            headers = {"referer"}
    )

    public String hello(){
        return "success";
    }

    @RequestMapping("/**/test/ant")
    public String testAnt(){
        return "success";
    }


    @RequestMapping("/test/rest/{username}/{id}")
    public String testRest(@PathVariable("id") Integer id, @PathVariable("username") String username){
        System.out.println("id:"+id+",username:"+username);
        return "success";
    }



}
