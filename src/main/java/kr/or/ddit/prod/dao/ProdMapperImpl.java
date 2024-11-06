package kr.or.ddit.prod.dao;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.ProdVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class ProdMapperImpl implements ProdMapper {

    private SqlSessionFactory sqlSessionFactory =
            CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

    @Override
    public int insertProd(ProdVO prod) {
        return 0;
    }

    @Override
    public ProdVO selectProd(String prodId) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ProdMapper mapperProxy = sqlSession.getMapper(ProdMapper.class);
            return mapperProxy.selectProd(prodId);
        }
    }

    @Override
    public List<ProdVO> selectProdList() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            ProdMapper mapperProxy = sqlSession.getMapper(ProdMapper.class);
            return mapperProxy.selectProdList();
        }
    }

    @Override
    public int updateProd(ProdVO prod) {
        return 0;
    }
}
