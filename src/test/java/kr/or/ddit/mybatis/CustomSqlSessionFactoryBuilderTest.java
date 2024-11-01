package kr.or.ddit.mybatis;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomSqlSessionFactoryBuilderTest {

    @Test
    void getSqlSessionFactory() {
       assertNotNull(CustomSqlSessionFactoryBuilder.getSqlSessionFactory());

    }
}