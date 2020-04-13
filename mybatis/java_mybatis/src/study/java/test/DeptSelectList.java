package study.java.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptSelectList {
    public static void main(String[] args) {
        // 1) 데이터베이스 접속
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) 데이터 조회
        // --> Mapper에서 변수를 사용하고 있지 않기 때문에 파라미터를 전달할 필요가 없다.
        List<Dept> output = sqlSession.selectList("Mapper.selectList", null);

        // 4) 결과 판별
        if (output == null) {
            System.out.println("조회결과 없음");
        } else {
            for (Dept item: output) {
                System.out.println(item.toString());
            }
        }

        // 5) DB 접속 해제
        sqlSession.close();
    }
}