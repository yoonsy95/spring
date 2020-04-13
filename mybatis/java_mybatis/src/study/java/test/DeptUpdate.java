package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptUpdate {
    public static void main(String[] args) {
        // 1) �����ͺ��̽� ����
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) ������ ������ �غ�
        Dept input = new Dept();
        input.setDeptno(101);
        input.setDname("�������а�");
        input.setLoc("��������ġ");

        // 3) ������ ���� --> ���ϰ��� ������ ���� ��
        int output = sqlSession.update("DepartmentMapper.updateItem", input);

        // 4) ��� �Ǻ�
        System.out.println(output + "���� ������ ������");

        // 5) ������� ���� �� DB ���� ����
        sqlSession.commit();
        sqlSession.close();
    }
}