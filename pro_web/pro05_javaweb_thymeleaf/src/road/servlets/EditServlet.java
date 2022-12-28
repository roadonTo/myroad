package road.servlets;

import road.dao.FruitDAO;
import road.dao.impl.FruitDAOImpl;
import road.pojo.Fruit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends ViewBaseServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String fid = req.getParameter("fid");

        FruitDAO fruitDao = new FruitDAOImpl();
        Fruit fruit = fruitDao.getFruitByFid(fid);
        req.setAttribute("fruit", fruit);

        super.processTemplate("edit", req, resp);

    }
}
