package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptUpdate {
    public static void main(String[] args) {
        // 1) 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) 변경할 데이터 준비
        Dept input = new Dept();
        input.setDeptno(101);
        input.setDname("수정된학과");
        input.setLoc("수정된위치");

        // 3) 데이터 수정 --> 리턴값은 수정된 행의 수
        int output = sqlSession.update("DepartmentMapper.updateItem", input);

        // 4) 결과 판별
        System.out.println(output + "개의 데이터 수정됨");

        // 5) 변경사항 저장 및 DB 접속 해제
        sqlSession.commit();
        sqlSession.close();
    }
}