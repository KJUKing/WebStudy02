package kr.or.ddit.member.service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{

    private MemberDAO dao = new MemberDAOImpl();
    private AuthenticateService authService = new AuthenticateServiceImpl();

    @Override
    public ServiceResult createMember(MemberVO member) {
        ServiceResult result = null;
        if (dao.selectMember(member.getMemId()) == null) {
            int rowcnt = dao.insertMember(member);
            result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
        } else {
            result = ServiceResult.PKDUPLICATED;
        }
        return result;
    }

    @Override
    public MemberVO readMember(String memId) throws PKNotFoundException {
        return Optional.ofNullable(dao.selectMember(memId))
                .orElseThrow(() -> new PKNotFoundException(String.format("%s라는 id는 없음", memId)));
    }

    @Override
    public List<MemberVO> readMemberList() {
        return dao.selectMemberList();
    }

    @Override
    public ServiceResult modifyMember(MemberVO member) {
        ServiceResult result = null;
        if (authService.authenticate(member) != null) {
            result = dao.update(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
        } else {
            result = ServiceResult.INVALIDPASSWORD;
        }
        return result;
    }

    @Override
    public ServiceResult removeMember(MemberVO member) {
        ServiceResult result = null;
        //다르게온 멤버정보의 2차인증으로 온 비밀번호를 다르게 입력받고 검증해야하는데
        //getUserPrinciple 로 뽑아낸 비밀번호는 사용자가 입력하지도않아도 당연하게 정답이되는문제가있다.
        if (authService.authenticate(member) != null) {
            result = dao.delete(member.getMemId()) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
        } else {
            result = ServiceResult.INVALIDPASSWORD;
        }
        return result;
    }
}
