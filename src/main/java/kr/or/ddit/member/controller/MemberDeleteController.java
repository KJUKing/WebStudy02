package kr.or.ddit.member.controller;

import kr.or.ddit.member.commons.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.Principal;

@WebServlet("/member/memberDelete.do")
public class MemberDeleteController extends HttpServlet {

    private MemberService service = new MemberServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lvn = null;
        HttpSession session = req.getSession();
        String memId = req.getUserPrincipal().getName();

        MemberVO member = service.readMember(memId);

        String memPass = req.getParameter("memPass");
        if (StringUtils.isBlank(memPass)) {
            lvn = "redirect:/mypage";
            session.setAttribute("message", "비밀번호 누락");
        }else {
            MemberVO inputData = new MemberVO();
            inputData.setMemId(memId);
            inputData.setMemPass(memPass);
            ServiceResult result = service.removeMember(inputData);
            switch (result) {
                case OK:
                    session.invalidate();
                    lvn = "redirect:/";
                    break;
                case INVALIDPASSWORD:
                    lvn = "redirect:/mypage";
                    session.setAttribute("message", "비밀번호 오류");
                    break;
                default:
                    lvn = "redirect:/mypage";
                    session.setAttribute("message", "서버 오류 다시시도하셈");
                    break;
            }
        }
        if (lvn.startsWith("redirect:")) {
            String location = lvn.replace("redirect:", req.getContextPath());
            resp.sendRedirect(location);
        } else {
            req.getRequestDispatcher("/" + lvn + ".tiles").forward(req, resp);
        }
        ServiceResult result = service.removeMember(member);
    }
}

