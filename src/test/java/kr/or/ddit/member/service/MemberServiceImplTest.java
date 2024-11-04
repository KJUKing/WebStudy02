package kr.or.ddit.member.service;

import kr.or.ddit.member.commons.exception.PKNotFoundException;
import kr.or.ddit.member.dao.MemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceImplTest {

    MemberDAO dao = new MemberDAOImpl();
    MemberService service = new MemberServiceImpl();

    @Test
    void createMember() {

    }

    @Test
    void readMember() {
        assertNotNull(service.readMember("a001"));
        assertThrows(PKNotFoundException.class, () -> {
            service.readMember("asdasdasd");
        });

    }

    @Test
    void readMemberList() {
        assertDoesNotThrow(() -> {
            service.readMemberList();
        });
    }

    @Test
    void modifyMember() {
    }

    @Test
    void removeMember() {
    }
}