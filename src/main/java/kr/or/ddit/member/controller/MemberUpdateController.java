package kr.or.ddit.member.controller;

import kr.or.ddit.member.commons.enumpkg.ServiceResult;
import kr.or.ddit.member.service.AuthenticateService;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.vo.MemberVO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@WebServlet("/member/memberUpdate.do")
public class MemberUpdateController extends HttpServlet {

    private MemberService service = new MemberServiceImpl();
    private AuthenticateService authService = new AuthenticateServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 유저프린시펄에서 멤버아이디꺼내와야함
        //2 멤버아이디로 단건조회해서 값갖고온거를 업데이트폼에 매핑시켜줘야함
        //3 기존데이터에서 새로조회한걸 아무튼 jsp에서 수정하고 전송버튼누르면
        //4 포스트로가서 다시 업데이트를 진행시켲무

        Principal userPrincipal = req.getUserPrincipal();
        String memId = userPrincipal.getName();

//        System.out.println("memId = " + memId);

        MemberVO member = service.readMember(memId);
        req.setAttribute("member", member);

        String lvn = "member/memberUpdateForm";
        if (lvn.startsWith("redirect:")) {
            String location = lvn.replace("redirect:", req.getContextPath());
            resp.sendRedirect(location);
        } else {
            req.getRequestDispatcher("/" +lvn+".tiles").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        MemberVO member = new MemberVO();
        req.setAttribute("member", member);
        try {
            BeanUtils.populate(member, req.getParameterMap());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new ServletException(e);
        }

        Map<String, String> errors = new HashMap<String, String>();
        req.setAttribute("errors", errors);
        validate(member, errors);
        String lvn = null;
        if (errors.isEmpty()) {
            ServiceResult result = service.modifyMember(member);
            switch (result) {
                case OK:
                    lvn = "redirect:/mypage";
                    changeAuthMember(member, req);
                    break;
                case INVALIDPASSWORD:
                    lvn = "member/memberUpdateForm";
                    req.setAttribute("message", "비밀번호 인증 실패");
                    break;
                default:
                    lvn = "member/memberUpdateForm";
                    req.setAttribute("message", "서버 오류, 다시가입하셈");
                    break;
            }
        } else {
            lvn = "member/memberUpdateForm";
        }

        if (lvn.startsWith("redirect:")) {
            String location = lvn.replace("redirect:", req.getContextPath());
            resp.sendRedirect(location);
        } else {
            req.getRequestDispatcher("/" +lvn+".tiles").forward(req, resp);
        }

    }


    private void changeAuthMember(MemberVO member, HttpServletRequest req) {
        MemberVO authMember = authService.authenticate(member);
        req.getSession().setAttribute("authMember", authMember);

    }

    private void validate(MemberVO member, Map<String, String> errors) {
        boolean valid = true;

        if (StringUtils.isBlank(member.getMemId())) {
            valid = false;
            errors.put("memId", "아이디 누락");
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
