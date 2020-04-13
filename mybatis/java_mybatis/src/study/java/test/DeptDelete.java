package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptDelete {
    public static void main(String[] args) {
        // 1) 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) 삭제할 데이터의 조건값 준비
        Dept input = new Dept();
        input.setDeptno(60);

        // 3) 데이터 삭제 --> 리턴값은 삭제된 행의 수
        int output = sqlSession.delete("Mapper.deleteItem", input);

        // 4) 결과 판별
        System.out.println(output + "개의 데이터 삭제됨");

        // 5) 변경사항 저장 및 DB 접속 해제
        sqlSession.commit();
        sqlSession.close();
    }
}
