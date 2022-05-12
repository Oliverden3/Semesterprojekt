package dat.startcode.control;

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
        String choice = request.getParameter("TSChoice");

       if (choice == "null"){
           request.getRequestDispatcher("PurchaseServlet").forward(request,response);
        }
        else {
           request.getRequestDispatcher("ToolShedSelectorServlet").forward(request,response);
        }

    }
}
