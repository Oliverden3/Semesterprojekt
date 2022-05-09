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
    Carport carport;

    @Override
    public void init() throws ServletException {
        ConnectionPool connectionPool = new ConnectionPool();

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ConnectionPool connectionPool = new ConnectionPool();
        CarportMapper carportmapper = new CarportMapper(connectionPool);
        response.setContentType("text/html");
        HttpSession session = request.getSession();
        session.getAttribute("idCarport");





        try {
            ArrayList<Carport> listCarport = carportmapper.getCarport();
            session.setAttribute("listCarport", listCarport);

            request.getRequestDispatcher("OrderTest.jsp").forward(request, response);
            request.getAttribute("Order.jsp");

        } catch (DatabaseException e) {
            e.printStackTrace();
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ConnectionPool connectionPool = new ConnectionPool();
        doGet(request, response);
        /*try{

            int carport_id = Integer.parseInt(request.getParameter("carport")+1);
            int carport_price = Integer.parseInt(request.getParameter("price"));
            OrderlineMapper orderlineMapper = new OrderlineMapper(connectionPool);
            orderlineMapper.createOrderline(topping_id,bottom_id,cupcake_price);



        }catch (DatabaseException e) {
            e.printStackTrace();
        }
*/
    }

}
