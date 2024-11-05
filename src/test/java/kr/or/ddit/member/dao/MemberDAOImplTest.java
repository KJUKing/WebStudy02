package kr.or.ddit.member.dao;

import kr.or.ddit.vo.MemberVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class MemberDAOImplTest {
    MemberDAO dao = new MemberDAOImpl();
//    static final Logger log = LoggerFactory.getLogger(MemberDAOImplTest.class);


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
//        assertNotNull(dao.selectMemberList());
        log.info("info 등급으로 기록한 로그 메세지");
        dao.selectMemberList()
                .forEach((m) -> log.info("조회된 결과 : {}", m));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}