package road.servlets;

import road.dao.FruitDAO;
import road.dao.impl.FruitDAOImpl;
import road.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

//Servlet从3.0版本开始 支持注解方式 配置映射 (以简化在web.xml中写servlet 和 servlet-mapping）
@WebServlet("/index")
public class IndexServlet extends ViewBaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpSession session = req.getSession();
        Integer pageNo = 1;
        String keyword = null;

        //1.判断是不是表单请求
        String search = req.getParameter("search");
        if (search != null && search.equals("search")) {
            pageNo = 1; //pageNo重置为1
            keyword = req.getParameter("keyword"); //表单请求 keyword从参数中获取
            if (keyword == null) {
                keyword = "";
            }
            session.setAttribute("keyword", keyword);
            session.setAttribute("pageNo", pageNo);
        } else { //不是表单请求,即点击上一页，下一页这样的
            //获取请求页数
            String pageNoStr = req.getParameter("pageNo");
            if (!(pageNoStr == null || "".equals(pageNoStr))) {
                pageNo = Integer.parseInt(pageNoStr);
            }
            session.setAttribute("pageNo", pageNo);
            Object keyword1 = session.getAttribute("keyword");
            if (keyword1 != null) {
                keyword = (String) keyword1;
            } else {
                keyword = "";
            }

        }

        int fruitCount = new FruitDAOImpl().getFruitCount(keyword);
        int pageCount = (fruitCount + 5 - 1) / 5;
        session.setAttribute("pageCount", pageCount); //尾页


        FruitDAO fruitDAO = new FruitDAOImpl();
//        List<Fruit> fruitList = fruitDAO.getFruitList();
        List<Fruit> fruitList = fruitDAO.getFruitList(pageNo, keyword);
        req.getSession().setAttribute("fruitList", fruitList);
        //     处理模板      逻辑视图名称“index” ，thymeleaf会将逻辑视图名称 对应到 物理视图 名称上去 ，物理视图名称为 /index.html
        super.processTemplate("index", req, resp);


    }
}

