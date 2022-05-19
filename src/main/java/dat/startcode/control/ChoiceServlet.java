package dat.startcode.control;

import dat.startcode.model.entities.*;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.persistence.ConnectionPool;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ChoiceServlet", value = "/ChoiceServlet")
public class ChoiceServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();
        int CarportWidth = Integer.parseInt(request.getParameter("WidthValue"));
        int CarportLength = Integer.parseInt(request.getParameter("LengthValue"));
        User user = (User)session.getAttribute("user");
        Order order = null;
        ConnectionPool connectionPool = new ConnectionPool();
        OrderMapper orderMapper = new OrderMapper(connectionPool);

        Roof roof = new Roof(1,"flat tag", 0);
        Toolshed toolshed = new Toolshed(1, 0, 0);

        try {
            order = orderMapper.createOrder(new java.sql.Date(System.currentTimeMillis()),CarportWidth,CarportLength,5,10000,roof,toolshed,"single");

        } catch (DatabaseException e) {
            e.printStackTrace();
        }

        session.setAttribute("order", order);
        session.setAttribute("toolshed", toolshed);

        String choice = request.getParameter("TSChoice");
        if (choice == null) {

            request.getRequestDispatcher("WEB-INF/purchase.jsp").forward(request, response);

        } else {

            request.getRequestDispatcher("WEB-INF/toolshedSelector.jsp").forward(request, response);
        }

    }
}
