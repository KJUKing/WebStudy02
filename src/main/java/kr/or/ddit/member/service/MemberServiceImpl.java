package kr.or.ddit.member.service;

import java.util.List;
import java.util.Optional;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
    private MemberDAO dao = new MemberDAOImpl();
    private AuthenticateService authService = new AuthenticateServiceImpl();

    @Override
    public ServiceResult createMember(MemberVO member) {
        ServiceResult result = null;
        if(dao.selectMember(member.getMemId())==null) {
            int rowcnt = dao.insertMember(member);
            result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
        }else {
            result = ServiceResult.PKDUPLICATED;
        }
        return result;
    }

    @Override
    public MemberVO readMember(String memId) throws PKNotFoundException {
        return Optional.ofNullable(dao.selectMember(memId))
                .orElseThrow(()->new PKNotFoundException(String.format("%s 회원 없음.", memId)));
    }

    @Override
    public List<MemberVO> readMemberList() {
        return dao.selectMemberList();
    }

    @Override
    public ServiceResult modifyMember(MemberVO member) {
        ServiceResult result = null;
        if(authService.authenticate(member)!=null) {
            result = dao.updateMember(member) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
        }else {
            result = ServiceResult.INVALIDPASSWORD;
        }
        return result;
    }

    @Override
    public ServiceResult removeMember(MemberVO inputData) {
        ServiceResult result = null;
        if(authService.authenticate(inputData)!=null) {
            result = dao.deleteMember(inputData.getMemId()) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
        }else {
            result = ServiceResult.INVALIDPASSWORD;
        }
        return result;
    }

}
