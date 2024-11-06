package kr.or.ddit.prod.dao;

import kr.or.ddit.vo.ProdVO;

import java.util.List;

/**
 * 상품관리(CRUD) persistence layer
 *
 */
public interface ProdMapper {

    public int insertProd(ProdVO prod);

    public ProdVO selectProd(String prodId);

    /**
     *
     * @return
     */
    public List<ProdVO> selectProdList();

    public int updateProd(ProdVO prod);

//    public int deleteProd(String prodId);
}


