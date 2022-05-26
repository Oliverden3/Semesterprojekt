package dat.startcode.control;

import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.lang.Integer.parseInt;

@WebServlet(name = "ConfirmOrderServlet", value = "/ConfirmOrderServlet")
public class ConfirmOrderServlet extends HttpServlet {

    private OrderMapper ordermapper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionpool = new ConnectionPool();
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        OrderMapper ordermapper = new OrderMapper(connectionpool);
        String status = "confirmed";
        int id = Integer.parseInt(request.getParameter("confirm"));


        try {
            ordermapper.confirmOrder(status, id);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
