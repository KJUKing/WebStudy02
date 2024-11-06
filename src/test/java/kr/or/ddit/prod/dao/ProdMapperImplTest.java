package kr.or.ddit.prod.dao;

import kr.or.ddit.vo.ProdVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class ProdMapperImplTest {

    ProdMapper dao = new ProdMapperImpl();

    @Test
    void insertProd() {
    }

    @Test
    void selectProd() {
        assertNotNull(dao.selectProd("P101000001"));
    }

    @Test
    void selectProdList() {

        assertDoesNotThrow(() -> dao.selectProdList()
                .forEach((m) -> log.info("조회된 결과 : {}, {}, {}", m.getProdName(), m.getLprod().getLprodNm()
                                                                    ,m.getBuyer().getBuyerName())));


    }

    @Test
    void updateProd() {
    }
}