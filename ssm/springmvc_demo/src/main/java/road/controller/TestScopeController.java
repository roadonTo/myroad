package road.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * 域对象共享数据
 * 向request，session，application域对象中保存数据
 * 前端用thymeleaf格式 取数据时，
 *      request中的数据直接${保存的参数名}，
 *      session中的数据用${session.保存的参数名},
 *      application中的数据用${applicaiton.保存的参数名}
 */


@Controller
public class TestScopeController {

    /**
     * 用servlet的API 向请求域（request）共享数据
     * @param request
     * @return
     */
    @RequestMapping("/scope")
    public String testscope(HttpServletRequest request){
        request.setAttribute("username","kangkang");
        return "success";
    }


    /**
     * 用modelAndView 向请求域共享数据，注意 必须返回用modelAndView 的对象
     * 前端页面中 可以用${model1} 来获取
     * @return
     */
    @RequestMapping("/scope1")
    public ModelAndView testScope1(){
        ModelAndView mav = new ModelAndView();
        mav.addObject("model","hello world");
        mav.setViewName("success");
        return mav;
    }


    /**
     * 用Model向请求域共享数据
     * @param model
     * @return
     */
    @RequestMapping("/scope2")
    public String testScope2(Model model){
        model.addAttribute("model1","hello world");
        return "success";
    }


    /**
     * 用ModelMap 向请求域共享数据
     * @param modelMap
     * @return
     */
    @RequestMapping("/scope3")
    public String testScope3(ModelMap modelMap){
        modelMap.addAttribute("modelMap1","hello world");
        return "success";
    }


    /**
     * 用Map 向请求域（request）共享数据
     * @param map
     * @return
     */
    @RequestMapping("/scope4")
    public String testScope4(Map<String, Object> map){
        map.put("map1","hello world");
        return "success";
        //前端接收：${map1}
    }


    /**
     * 向session域中保存数据
     * @param session
     * @return
     */
    @RequestMapping("/sessionScope")
    public String testSessionScope(HttpSession session){
        session.setAttribute("session1","hello session");

        return "success";
        //前端接收：${session.session1}
    }


    /**
     * 向会话域（application）中保存数据
     * @param session
     * @return
     */
    @RequestMapping("/applicationScope")
    public String testApplicationScope(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("application1","hello application");
        return "success";
        //前端接收：${application.application1}
    }





}
