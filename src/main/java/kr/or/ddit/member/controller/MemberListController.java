package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.definition.NoSuchDefinitionException;

import kr.or.ddit.member.service.MemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.mvc.ViewResolverComposite;
import kr.or.ddit.vo.MemberVO;

/**
 *  다건조회 : /member/memberList.do (ROLE_ADMIN)
 *  단건조회 : /member/memberDetail.do (ROLE_ADMIN)
 *  단건조회 : /mypage (ROLE_ADMIN,ROLE_USER)
 *  가입: /member/memberInsert.do(GET, POST)
 *  수정: /member/memberUpdate.do(GET, POST)(ROLE_ADMIN,ROLE_USER)
 *  탈퇴: /membmer/memberDelete.do(POST)(ROLE_ADMIN,ROLE_USER)
 *
 */
@WebServlet("/member/memberList.do")
public class MemberListController extends HttpServlet{

    private MemberService service = new MemberServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<MemberVO> memberList = service.readMemberList();

        req.setAttribute("list", memberList);

        String lvn = "member/memberList"; // ==> definition name

        new ViewResolverComposite().resolveView(lvn, req, resp);
    }

}












