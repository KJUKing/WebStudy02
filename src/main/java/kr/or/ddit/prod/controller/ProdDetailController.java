package kr.or.ddit.prod.controller;

import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.vo.ProdVO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/prod/prodDetail.do")
public class ProdDetailController extends HttpServlet {
    private ProdService service = new ProdServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String prodId = req.getParameter("what");
        if (StringUtils.isBlank(prodId)) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "필수 파라미터가 없는데");
            return;
        }

        ProdVO prod = service.readProd(prodId);

        req.setAttribute("prod", prod);
        String lvn = "prod/prodDetail";

        if (lvn.startsWith("redirect:")) {
            String location = lvn.replace("redirect:", req.getContextPath());
            resp.sendRedirect(location);
        } else {
            req.getRequestDispatcher("/" +lvn+".tiles").forward(req, resp);
        }
    }
}
