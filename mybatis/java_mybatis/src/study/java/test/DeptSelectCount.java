package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.mybatis.MyBatisConnectionFactory;

public class DeptSelectCount {
    public static void main(String[] args) {
        // 1) 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) 데이터 조회
        int count = sqlSession.selectOne("Mapper.selectCount", null);

        // 4) 결과 판별
        System.out.println(count + "개의 데이터 있음");

        // 5) DB 접속 해제
        sqlSession.close();
    }
}