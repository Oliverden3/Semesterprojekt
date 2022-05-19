package dat.startcode.control;

import dat.startcode.model.entities.Order;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        OrderMapper orderMapper = new OrderMapper(connectionPool);
        HttpSession session = request.getSession();

        try {
          List<Order> orderList = orderMapper.getOrders();
          request.setAttribute("orderList",orderList);

        } catch (DatabaseException e) {
            e.printStackTrace();
        }
        request.getRequestDispatcher("admin.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
