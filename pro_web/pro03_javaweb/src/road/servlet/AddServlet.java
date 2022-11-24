package road.servlet;

import road.dao.FruitDAO;
import road.dao.base.BaseDAO;
import road.dao.impl.FruitDAOImpl;
import road.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String fname = req.getParameter("fname");
        int price = Integer.parseInt(req.getParameter("price"));
        int acount = Integer.parseInt(req.getParameter("acount"));
        String remark = req.getParameter("remark");

        Fruit fruit = new Fruit(0, fname, price, acount, remark);

        FruitDAO fruitDAO = new FruitDAOImpl();
        boolean b = fruitDAO.addFruit(fruit);
        System.out.println(b ? "添加成功" : "添加失败");

    }
}
