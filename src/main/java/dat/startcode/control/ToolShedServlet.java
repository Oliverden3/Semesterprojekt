package dat.startcode.control;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ToolShedServlet", value = "/ToolShedServlet")
public class ToolShedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String choice = request.getParameter("TSChoice");

        if (choice == "off"){
            request.getRequestDispatcher("PurchaseServlet").forward(request,response);
        }
        else {
            request.getRequestDispatcher("ToolShedSelectorServlet").forward(request,response);
        }

    }
}
