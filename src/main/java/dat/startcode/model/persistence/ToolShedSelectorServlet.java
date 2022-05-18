package dat.startcode.model.persistence;

import dat.startcode.model.entities.Toolshed;
import dat.startcode.model.exceptions.DatabaseException;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ToolShedSelectorServlet", value = "/ToolShedSelectorServlet")
public class ToolShedSelectorServlet extends HttpServlet {
    ConnectionPool connectionPool = new ConnectionPool();
    ToolShedMapper toolShedMapper = new ToolShedMapper(connectionPool);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        HttpSession session = request.getSession();

        try {
           List<Toolshed> toolshedList = toolShedMapper.getToolshed();
           session.setAttribute("toolShedList",toolshedList);
           request.getRequestDispatcher("toolshed.jsp");
        } catch (DatabaseException e) {
            e.printStackTrace();
        }
    }
}
