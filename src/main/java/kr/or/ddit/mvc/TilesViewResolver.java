package kr.or.ddit.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TilesViewResolver implements ViewResolver {

    @Override
    public void resolveView(String lvn, HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/" + lvn + ".tiles").forward(req, resp);
    }

}
