package kr.or.ddit.member.controller;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.member.service.AuthenticateService;
import kr.or.ddit.member.service.AuthenticateServiceImpl;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.UpdateGroup;
import kr.or.ddit.vo.MemberVO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        PopulateUtils.populate(member, req.getParameterMap());

        Map<String, List<String>> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        ValidateUtils.validate(member, errors, UpdateGroup.class);
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
        new ViewResolverComposite().resolveView(lvn, req, resp);

    }

    private void changeAuthMember(MemberVO member, HttpServletRequest req) {
        MemberVO authMember = authService.authenticate(member);
        req.getSession().setAttribute("authMember", authMember);

    }

}
