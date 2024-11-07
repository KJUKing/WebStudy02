package kr.or.ddit.mvc;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class InternalResourceViewResolver implements ViewResolver {

    @Override
    public void resolveView(String lvn, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher(lvn + ".jsp").forward(req, resp);
    }

}
