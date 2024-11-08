package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;

@WebServlet("/member/memberDetail.do")
public class MemberDetailController extends HttpServlet {
    private MemberService service = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String memId = req.getParameter("who");
        if(StringUtils.isBlank(memId)) {
            resp.sendError(400, "필수 파라미터 누락");
            return;
        }

        MemberVO member = service.readMember(memId);
//		req.setAttribute("wrapper", new WrapperVO<MemberVO>(member));
        req.setAttribute("member", member);

        String lvn = "member/memberDetail";

        new ViewResolverComposite().resolveView(lvn, req, resp);
    }
}











