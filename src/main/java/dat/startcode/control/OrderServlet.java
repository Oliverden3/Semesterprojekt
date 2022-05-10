package dat.startcode.control;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.CarportMapper;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "OrderServlet", value = "/OrderServlet")

public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        CarportMapper carportMapper = new CarportMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try{
            ArrayList<Carport> listCarport = carportMapper.getCarport();
            session.setAttribute("listCarport",listCarport);

            request.getRequestDispatcher("index.jsp").forward(request,response);

        }catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
