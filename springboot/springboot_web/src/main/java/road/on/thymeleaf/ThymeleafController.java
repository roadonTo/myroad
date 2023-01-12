package road.on.thymeleaf;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import road.on.domain.User;
import road.on.service.UserService;

import java.util.List;

@Controller
public class ThymeleafController {

    @Autowired
    private UserService userService;

    @RequestMapping("/thymeleaf/users")
    public String users(Model model){
        //获取数据
        List<User> users = userService.findAll();
        //望域中存入数据
        model.addAttribute("users",users);
        model.addAttribute("msg","hello thymeleaf");
        //页面跳转
        return "table-standard";
    }
}
