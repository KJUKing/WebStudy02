package kr.or.ddit.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.mybatis.CustomSqlSessionFactoryBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements MemberDAO {
    private SqlSessionFactory sqlSessionFactory =
            CustomSqlSessionFactoryBuilder.getSqlSessionFactory();

    @Override
    public int insertMember(MemberVO member) {
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession();
        ){
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            int cnt = mapperProxy.insertMember(member);
            if(cnt>0) sqlSession.commit();
            return cnt;
        }
    }

    @Override
    public MemberVO selectMember(String memId) {
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
        ) {
            return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMember", memId);
        }
    }

    @Override
    public MemberVO selectMemberForAuth(String memId) {

        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
        ) {
//			return sqlSession.selectOne("kr.or.ddit.member.dao.MemberDAO.selectMemberForAuth", memId);
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            return mapperProxy.selectMemberForAuth(memId);
        }
    }


    @Override
    public List<MemberVO> selectMemberList() {
        try (
                SqlSession sqlSession = sqlSessionFactory.openSession();
        ) {
//			return sqlSession.selectList("kr.or.ddit.member.dao.MemberDAO.selectMemberList");
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            return mapperProxy.selectMemberList();
        }
    }

    @Override
    public int updateMember(MemberVO member) {
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession();
        ){
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            int cnt = mapperProxy.updateMember(member);
            if(cnt>0) sqlSession.commit();
            return cnt;
        }
    }

    @Override
    public int deleteMember(String memId) {
        try(
                SqlSession sqlSession = sqlSessionFactory.openSession();
        ){
            MemberDAO mapperProxy = sqlSession.getMapper(MemberDAO.class);
            int cnt = mapperProxy.deleteMember(memId);
            if(cnt>0) sqlSession.commit();
            return cnt;
        }
    }

}
