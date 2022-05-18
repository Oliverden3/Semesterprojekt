package dat.startcode.control;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.entities.Toolshed;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "PurchaseServlet", value = "/PurchaseServlet")
public class PurchaseServletDeleted extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        int CarportWidth = Integer.parseInt(request.getParameter("listWidth"));
        int CarportLength = Integer.parseInt(request.getParameter("listLength"));

        Roof roof = new Roof("Flat",10);
        Toolshed toolshed = new Toolshed(1,3,3);
        Carport carport = new Carport(1,CarportWidth,CarportLength,10000,4,roof,toolshed,"flat");

        session.setAttribute("carport",carport);

        request.getRequestDispatcher("WEB-INF/purchase.jsp").forward(request,response);




    }
}
