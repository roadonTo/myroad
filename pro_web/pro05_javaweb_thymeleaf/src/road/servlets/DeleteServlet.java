package road.servlets;

import road.dao.FruitDAO;
import road.dao.impl.FruitDAOImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends ViewBaseServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int fid = Integer.parseInt(req.getParameter("fid"));
        FruitDAO fruitDAO = new FruitDAOImpl();
        fruitDAO.deleteFruit(fid);

        resp.sendRedirect("index");
    }
}
