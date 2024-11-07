package kr.or.ddit.prod.service;

import kr.or.ddit.commons.enumpkg.ServiceResult;
import kr.or.ddit.commons.exception.PKNotFoundException;
import kr.or.ddit.prod.dao.ProdMapper;
import kr.or.ddit.prod.dao.ProdMapperImpl;
import kr.or.ddit.vo.ProdVO;

import java.util.List;
import java.util.Optional;

public class ProdServiceImpl implements ProdService {

    private ProdMapper dao = new ProdMapperImpl();

    @Override
    public ServiceResult createProd(ProdVO prod) {
        return dao.insertProd(prod) > 0 ? ServiceResult.OK : ServiceResult.FAIL;
    }

    @Override
    public ProdVO readProd(String prodId) throws PKNotFoundException {
        return Optional.ofNullable(dao.selectProd(prodId))
                .orElseThrow(() -> new PKNotFoundException(String.format("%s라는 상품명은 없는듯", prodId)));
    }

    @Override
    public List<ProdVO> readProdList() {
        return dao.selectProdList();
    }

    @Override
    public ServiceResult modifyProd(ProdVO prod) {
        return null;
    }
}
