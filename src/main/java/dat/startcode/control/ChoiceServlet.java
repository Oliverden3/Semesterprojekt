package dat.startcode.control;

import dat.startcode.model.entities.Carport;
import dat.startcode.model.entities.Roof;
import dat.startcode.model.entities.Toolshed;

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

        String choice = request.getParameter("TSChoice");
        if (choice == null) {

            int CarportWidth = Integer.parseInt(request.getParameter("WidthValue"));
            int CarportLength = Integer.parseInt(request.getParameter("LengthValue"));
            int TSWidth = Integer.parseInt(request.getParameter("WidthValueTS"));
            int TSLength = Integer.parseInt(request.getParameter("LengthValueTS"));


            Roof roof = new Roof("Flat", 0);
            Toolshed toolshed = new Toolshed(0, TSWidth, TSLength);
            Carport carport = new Carport(1, CarportWidth, CarportLength, 10000, 4, roof, toolshed, "single");

            session.setAttribute("carport", carport);
            session.setAttribute("toolshed", toolshed);

            request.getRequestDispatcher("WEB-INF/purchase.jsp").forward(request, response);
            // request.getRequestDispatcher("PurchaseServlet").forward(request,response);
        } else {

            request.getRequestDispatcher("WEB-INF/toolshedSelector.jsp").forward(request, response);
        }

    }
}
