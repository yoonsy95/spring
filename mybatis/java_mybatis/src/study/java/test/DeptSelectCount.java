package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.mybatis.MyBatisConnectionFactory;

public class DeptSelectCount {
    public static void main(String[] args) {
        // 1) �����ͺ��̽� ����
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) ������ ��ȸ
        int count = sqlSession.selectOne("Mapper.selectCount", null);

        // 4) ��� �Ǻ�
        System.out.println(count + "���� ������ ����");

        // 5) DB ���� ����
        sqlSession.close();
    }
}