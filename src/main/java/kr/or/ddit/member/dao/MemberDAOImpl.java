package kr.or.ddit.member.dao;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Collections;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {


    private SqlSessionFactory sqlSessionFactory =
            CustomSqlSessionFactoryBuilder.getSqlSessionFactory();


    @Override
    public int insertMember(MemberVO member) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            int cnt = mapperProxy.insertMember(member);
            if (cnt > 0) {
                sqlSession.commit();
            }
            System.out.println("나 콘솔찍혔는지 다오확인용");
            return cnt;
        }
    }

    @Override
    public MemberVO selectMember(String memId) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
        }
    }

    @Override
    public MemberVO selectMemberForAuth(String memId) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            return mapperProxy.selectMemberForAuth(memId);
        }
    }


    @Override
    public List<MemberVO> selectMemberList() {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
//            return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            return mapperProxy.selectMemberList();
        }
    }

    @Override
    public int update(MemberVO member) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            int cnt = mapperProxy.update(member);
            if (cnt > 0) sqlSession.commit();
            return cnt;
        }
    }

    @Override
    public int delete(@Param("memId") String memId) {
        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            int cnt = mapperProxy.delete(memId);
            if (cnt > 0) sqlSession.commit();
            return cnt;
        }

    }
}
