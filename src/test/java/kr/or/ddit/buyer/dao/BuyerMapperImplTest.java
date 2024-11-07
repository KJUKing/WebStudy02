package kr.or.ddit.buyer.dao;

import kr.or.ddit.vo.BuyerVO;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BuyerMapperImplTest {

    BuyerMapper buyerMapper = new BuyerMapperImpl();

    @Test
    void selectBuyer() {
    }

    @Test
    void selectBuyerList() {
        List<BuyerVO> buyerVOS = buyerMapper.selectBuyerList();
        assertNotNull(buyerVOS);
    }
}