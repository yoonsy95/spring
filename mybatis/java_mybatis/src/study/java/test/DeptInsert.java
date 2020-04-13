package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptInsert {
    public static void main(String[] args) {
        // 1) 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) 저장할 데이터 준비
        Dept input = new Dept();
        input.setDeptno(60);
        input.setDname("JAVA학과");
        input.setLoc("공학관");

        // 3) 데이터 저장 --> 리턴값은 저장된 행의 수
        System.out.println(input);
        int output = sqlSession.insert("Mapper.insertItem", input);

        // 4) 결과 판별
        System.out.println(output + "개의 데이터 저장됨");

        // 5) 변경사항 저장 및 DB 접속 해제
        sqlSession.commit();
        sqlSession.close();
    }
}
