package dat.startcode.model.persistence;

import dat.startcode.model.entities.Toolshed;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ToolShedLoaderServlet", value = "/ToolShedLoaderServlet")
public class ToolShedLoaderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        HttpSession session = request.getSession();

        int TSWidth = Integer.parseInt(request.getParameter("WidthValueTS"));
        int TSLength = Integer.parseInt(request.getParameter("LengthValueTS"));
        Toolshed toolshed = new Toolshed(0, TSWidth, TSLength);
        session.setAttribute("toolshed",toolshed);

        request.getRequestDispatcher("WEB-INF/purchase.jsp").forward(request,response);

    }
}
