package kr.or.ddit.mbti.dao;

import kr.or.ddit.vo.MbtiVO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MbtiMapperImplTest {

    MbtiMapper dao = new MbtiMapperImpl();

    @Test
    void selectMbtiList() {
        List<MbtiVO> mbtiList = dao.selectMbtiList();
        assertNotNull(mbtiList);
    }

    @Test
    void selectMbti() {
        MbtiVO estj = dao.selectMbti("estj");
        assertNotNull(estj);
    }
}