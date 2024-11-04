package kr.or.ddit.member.controller;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/member/memberDetail.do")
public class MemberDetailController extends HttpServlet {

    private MemberService service = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memId = req.getParameter("who");
        if(StringUtils.isBlank(memId)){
            resp.sendError(400, "필수 파라미터 누락");
            return;
        }

        MemberVO member = service.readMember(memId);

        req.setAttribute("member", member);
        req.getRequestDispatcher("/member/memberDetail.tiles").forward(req, resp);
    }
}
