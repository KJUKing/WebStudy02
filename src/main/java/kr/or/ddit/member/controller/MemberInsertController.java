package kr.or.ddit.member.controller;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.utils.PopulateUtils;
import kr.or.ddit.utils.ValidateUtils;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.vo.MemberVO;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/member/memberInsert.do")
public class MemberInsertController extends HttpServlet {

    private MemberService service = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String lvn = "member/memberForm";

        new ViewResolverComposite().resolveView(lvn, req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * 1. 요청 파라미터 획득 (17개)
         * 2. MemberVO에 파라미터 바인드
         * 3. 유효성 검증
         * 4. 통과
         *      1) 로직 실행(createMember)
         *      2) 성공 : 로그인 페이지로 이동(redirect) : PRG
         *      3) 실패 : memberForm 이동(forward) (기존 입력 데이터와 알림메세지 전달)
         *      4) 중복 : memberForm 이동(forward) (기존 입력 데이터와 알림메세지 전달)
         *  5. 실패 memberForm 이동(forward) (기존 입력 데이터와 검증 에러 메세지 전달)
         */

        MemberVO member = new MemberVO();
        req.setAttribute("member", member);
        PopulateUtils.populate(member, req.getParameterMap());


        Map<String, List<String>> errors = new HashMap<>();
        req.setAttribute("errors", errors);
        ValidateUtils.validate(member, errors, InsertGroup.class);
        String lvn = null;
        if (errors.isEmpty()) {
            ServiceResult result = service.createMember(member);
            switch (result) {
                case OK:
                    lvn = "redirect:/login/loginForm.jsp";
                    break;
                case PKDUPLICATED:
                    lvn = "member/memberForm";
                    req.setAttribute("message", "아이디 중복, 바꾸셈");
                    break;
                default:
                    lvn = "member/memberForm";
                    req.setAttribute("message", "서버 오류, 다시가입하셈");
                    break;
            }
        } else {
            lvn = "member/memberForm";
        }

        new ViewResolverComposite().resolveView(lvn, req, resp);

    }

}

