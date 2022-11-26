package road.servlets;

import road.dao.FruitDAO;
import road.dao.impl.FruitDAOImpl;
import road.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//Servlet从3.0版本开始 支持注解方式 配置映射 (以简化在web.xml中写servlet 和 servlet-mapping）
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FruitDAO fruitDAO = new FruitDAOImpl();
        List<Fruit> fruitList = fruitDAO.getFruitList();
        req.getSession().setAttribute("fruitList",fruitList);
        //     处理模板      逻辑视图名称“index” ，thymeleaf会将逻辑视图名称 对应到 物理视图 名称上去 ，物理视图名称为 /index.html
        super.processTemplate("index",req,resp);



    }
}
