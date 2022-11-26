package road.servlets;

import road.dao.FruitDAO;
import road.dao.impl.FruitDAOImpl;
import road.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/update.do")
public class UpdateServlet extends ViewBaseServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String fid = req.getParameter("fid");
        int fid1 = Integer.parseInt(fid);
        String fname = req.getParameter("fname");
        String price = req.getParameter("price");
        int price1 = Integer.parseInt(price);
        String fcount = req.getParameter("fcount");
        int fcount1 = Integer.parseInt(fcount);
        String remark = req.getParameter("remark");

        Fruit fruit = new Fruit(fid1, fname, price1, fcount1, remark);

        FruitDAO fruitDAO = new FruitDAOImpl();
        fruitDAO.updateFruit(fruit);

        // 执行更新后需要返回首页显示 （查询）更新后的数据库数据
//        super.processTemplate("index",req,resp); //这个相当于服务器内部转发，显示的是之前存储在session中的旧数据
        resp.sendRedirect("index"); //需要用这个重定向 才能再次查询数据库 显示出来 更新后的数据


    }
}
