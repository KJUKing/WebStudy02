package kr.or.ddit.mbti.dao;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MbtiVO;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class MbtiMapperImpl implements MbtiMapper {

    private SqlSessionFactory sqlSessionFactory =
            CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

    @Override
    public int insertMbti(MbtiVO mbti) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)) {
            return sqlSession.getMapper(MbtiMapper.class).insertMbti(mbti);
        }
    }

    @Override
    public MbtiVO selectMbti(String mbtiType) {
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession();
                ){
            return sqlSession.getMapper(MbtiMapper.class).selectMbti(mbtiType);

        }
    }

    @Override
    public List<MbtiVO> selectMbtiList() {
        try(SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.getMapper(MbtiMapper.class).selectMbtiList();
        }
    }

    @Override
    public int updateMbti(MbtiVO mbti) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            return sqlSession.getMapper(MbtiMapper.class).updateMbti(mbti);
        }
    }

    @Override
    public int deleteMbti(String mbtiType) {
        try(SqlSession sqlSession = sqlSessionFactory.openSession(true)){
            return sqlSession.getMapper(MbtiMapper.class).deleteMbti(mbtiType);
        }
    }
}
