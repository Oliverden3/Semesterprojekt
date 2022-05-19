package dat.startcode.control;

import dat.startcode.model.entities.Order;
import dat.startcode.model.entities.PartslistItem;
import dat.startcode.model.exceptions.DatabaseException;
import dat.startcode.model.persistence.ConnectionPool;
import dat.startcode.model.persistence.OrderMapper;
import dat.startcode.model.persistence.PartslistMapper;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PartslistServlet", value = "/PartslistServlet")
public class PartslistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int idOrders= Integer.parseInt(request.getParameter("idOrders"));

        ConnectionPool connectionPool = new ConnectionPool();
        OrderMapper orderMapper = new OrderMapper(connectionPool);

        try {
            Order order = orderMapper.getOrdersById(idOrders);
            PartslistMapper partslistMapper = new PartslistMapper(connectionPool);

            List<PartslistItem> partslistItems = partslistMapper.getPartslist();
            request.setAttribute("partsItemList",partslistItems);
            // Hent partslist fra database hørende til vores ordre

            // Gem listen på requestscope
            // hop til jsp siden og vis stykliste
            request.getRequestDispatcher("WEB-INF/partslist.jsp").forward(request,response);
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
