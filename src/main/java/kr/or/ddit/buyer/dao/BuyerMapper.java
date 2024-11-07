package kr.or.ddit.buyer.dao;

import kr.or.ddit.vo.BuyerVO;

import java.util.List;

public interface BuyerMapper {
    public BuyerVO selectBuyer(String buyerId);
    public List<BuyerVO> selectBuyerList();
}
