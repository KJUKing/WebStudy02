package kr.or.ddit.member.controller;

import kr.or.ddit.login.auth.MemberVOWrapper;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/mypage")
public class myPageController extends HttpServlet {

    MemberService service = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberVOWrapper principal = (MemberVOWrapper) req.getUserPrincipal();
//        MemberVO authMember = principal.getRealUser();

        MemberVO member = service.readMember(principal.getName());
        req.setAttribute("member", member);

        String lvn = "member/memberDetail";

        new ViewResolverComposite().resolveView(lvn, req, resp);
    }
}
