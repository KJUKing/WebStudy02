package kr.or.ddit.member.service;

import kr.or.ddit.member.commons.enumpkg.ServiceResult;
import kr.or.ddit.member.commons.exception.PKNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

import java.util.List;
import java.util.Optional;

public class MemberServiceImpl implements MemberService{

    private MemberDAO dao = new MemberDAOImpl();

    @Override
    public ServiceResult createMember(MemberVO member) {
        MemberVO searchMember = dao.selectMember(member.getMemId());
        if (searchMember != null) {
            return ServiceResult.PKDUPLICATED;
        }
        int i = dao.insertMember(member);
        if (i > 0) {
            return ServiceResult.OK;
        } else {
            return ServiceResult.FAIL;
        }


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
        return null;
    }

    @Override
    public ServiceResult removeMember(MemberVO member) {
        return null;
    }
}
