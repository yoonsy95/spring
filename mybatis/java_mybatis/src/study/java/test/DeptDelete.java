package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptDelete {
    public static void main(String[] args) {
        // 1) �����ͺ��̽� ����
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) ������ �������� ���ǰ� �غ�
        Dept input = new Dept();
        input.setDeptno(60);

        // 3) ������ ���� --> ���ϰ��� ������ ���� ��
        int output = sqlSession.delete("Mapper.deleteItem", input);

        // 4) ��� �Ǻ�
        System.out.println(output + "���� ������ ������");

        // 5) ������� ���� �� DB ���� ����
        sqlSession.commit();
        sqlSession.close();
    }
}
