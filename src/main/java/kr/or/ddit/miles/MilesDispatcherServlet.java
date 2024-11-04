package kr.or.ddit.miles;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.miles")
public class MilesDispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println(req.getServletPath());
        String servletPath = req.getServletPath();
        int lastIndex = servletPath.lastIndexOf(".miles");
        String logicalViewName = servletPath.substring(1).substring(0, lastIndex-1);
        String viewName = String.format("WEB-INF/views/%s.jsp", logicalViewName);
        req.setAttribute("viewName", viewName);

        req.getRequestDispatcher("/WEB-INF/views/layout1.jsp").forward(req, resp);
    }
}
