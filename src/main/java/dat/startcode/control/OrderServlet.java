package dat.startcode.control;

import dat.startcode.model.entities.Order;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.OrderMapper;
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
        OrderMapper orderMapper = new OrderMapper(connectionPool);

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        try{

            ArrayList<Order> listOrder = orderMapper.getOrders();
            session.setAttribute("listOrder",listOrder);

            request.getRequestDispatcher("WEB-INF/orderCarport.jsp").forward(request,response);

        }catch (DatabaseException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}
