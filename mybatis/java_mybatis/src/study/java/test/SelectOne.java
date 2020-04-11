package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.mybatis.MyBatisConnectionFactory;
import study.java.model.Dept;

public class SelectOne {
    public static void main(String[] args) {
        // 1) 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) 조회할 데이터 (null로 사용할 값은 설정하지 않는다)
        Dept input = new Dept();
        input.setDeptno(10);

        // 3) 데이터 조회
        Dept output = sqlSession.selectOne("Mapper.selectItem", input);

        // 4) 결과 판별
        if (output == null) {
            System.out.println("조회결과 없음");
        } else {
            System.out.println(output.toString());
        }

        // 5) DB 접속 해제
        sqlSession.close();
    }
}
