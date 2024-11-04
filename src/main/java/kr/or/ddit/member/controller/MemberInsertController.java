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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/member/memberInsert.do")
public class MemberInsertController extends HttpServlet {

    private MemberService service = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lvn = "member/memberForm";
        req.getRequestDispatcher("/" + lvn +".tiles").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("나 찎혔는지 콘솔확인용");
        MemberVO member = new MemberVO();

        member.setMemId(req.getParameter("memId"));
        member.setMemPass(req.getParameter("memPass"));
        member.setMemName(req.getParameter("memName"));
        member.setMemRegno1(req.getParameter("memRegno1"));
        member.setMemRegno2(req.getParameter("memRegno2"));
        member.setMemZip(req.getParameter("memZip"));
        member.setMemAdd1(req.getParameter("memAdd1"));
        member.setMemAdd2(req.getParameter("memAdd2"));
        member.setMemHometel(req.getParameter("memHometel"));
        member.setMemComtel(req.getParameter("memComtel"));
        member.setMemHp(req.getParameter("memHp"));
        member.setMemMail(req.getParameter("memMail"));
        member.setMemJob(req.getParameter("memJob"));
        member.setMemLike(req.getParameter("memLike"));
        member.setMemMemorial(req.getParameter("memMemorial"));

        Map<String, String> errors = new HashMap<String, String>();
        validatie(member, errors);
        boolean valid = errors.isEmpty();

        System.out.println("나 찍혔는지 확인 2");


        if (valid) {
            ServiceResult result = service.createMember(member);
            System.out.println("result = " + result);
            if (result==ServiceResult.PKDUPLICATED) {
                errors.put("memId", "아이디가 중복이야");
                resp.sendError(HttpServletResponse.SC_CONFLICT, errors.toString());
            } else if (result == ServiceResult.OK) {
                resp.sendRedirect(req.getContextPath() + "/member/memberList.do");
            } else {
                resp.sendError(400, errors.toString());
            }
        }
    }

    private void validatie(MemberVO member, Map<String, String> errors) {
        boolean valid = true;

        if (StringUtils.isBlank(member.getMemId())) {
            valid = false;
            errors.put("id", "아이디 누락");
        }

        if (StringUtils.isBlank(member.getMemPass())) {
            valid = false;
            errors.put("password", "패스워드 누락");
        }

        if (StringUtils.isBlank(member.getMemName())) {
            valid = false;
            errors.put("name", "이름 누락");
        }

        if (StringUtils.isBlank(member.getMemZip())) {
            valid = false;
            errors.put("zip", "우편번호 누락");
        }

        if (StringUtils.isBlank(member.getMemAdd1())) {
            valid = false;
            errors.put("Address", "주소1 누락");
        }

        if (StringUtils.isBlank(member.getMemAdd2())) {
            valid = false;
            errors.put("Address2", "상세주소 누락");
        }

        if (StringUtils.isBlank(member.getMemMail())) {
            valid = false;
            errors.put("mail", "메일 누락");
        }
    }
}
