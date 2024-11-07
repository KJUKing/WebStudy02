package kr.or.ddit.buyer.dao;

import kr.or.ddit.lprod.dao.LprodMapper;
import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.BuyerVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BuyerMapperImpl implements BuyerMapper {

    private SqlSessionFactory sqlSessionFactory =
            CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

    @Override
    public BuyerVO selectBuyer(String buyerId) {
        return null;
    }

    @Override
    public List<BuyerVO> selectBuyerList() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            BuyerMapper mapperProxy = sqlSession.getMapper(BuyerMapper.class);
            return mapperProxy.selectBuyerList();
        }
    }
}
