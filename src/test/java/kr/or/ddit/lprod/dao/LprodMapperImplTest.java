package kr.or.ddit.lprod.dao;

import kr.or.ddit.vo.LprodVO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LprodMapperImplTest {

    LprodMapper mapper = new LprodMapperImpl();
    @Test
    void selectLprodList() {
        List<LprodVO> voList = mapper.selectLprodList();
        assertNotNull(voList);
    }
}