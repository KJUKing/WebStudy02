package kr.or.ddit.buyer.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import kr.or.ddit.vo.BuyerVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
class BuyerMapperImplTest {
    BuyerMapper mapper = new BuyerMapperImpl();

    @Test
    void testSelectBuyer() {
        BuyerVO buyer = mapper.selectBuyer("P10101");
        log.info("조회된 결과 : {}", buyer);
    }

}
