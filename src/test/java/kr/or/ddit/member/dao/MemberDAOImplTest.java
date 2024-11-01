package kr.or.ddit.member.dao;

import kr.or.ddit.vo.MemberVO;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MemberDAOImplTest {
    MemberDAO dao = new MemberDAOImpl();

    @Test
    void insertMember() {
        MemberVO newMember = dao.selectMember("a001");
        newMember.setMemId("a003");
        assertEquals(1, dao.insertMember(newMember));
    }

    @Test
    void selectMember() {
        assertNotNull(dao.selectMember("c001"));
    }

    @Test
    void selectMemberForAuth() {
        assertNotNull(dao.selectMemberForAuth("c001"));
    }

    @Test
    void selectMemberList() {

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}