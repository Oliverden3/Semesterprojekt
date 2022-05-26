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

@WebServlet(name = "Servlet", value = "/Servlet")
public class DeclineOrderServlet extends HttpServlet {

    private ConnectionPool connectionpool;
    private OrderMapper ordermapper;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        OrderMapper ordermapper = new OrderMapper(connectionpool);
        String status = (request.getParameter("declined"));
        int id = Integer.parseInt(request.getParameter("idOrders"));


        try {
            ordermapper.confirmOrder(status, id);
        }
        catch (DatabaseException e)
        {
            Logger.getLogger("web").log(Level.SEVERE, e.getMessage());
            request.setAttribute("errormessage", e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
    }

