package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptInsert {
    public static void main(String[] args) {
        // 1) �����ͺ��̽� ����
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) ������ ������ �غ�
        Dept input = new Dept();
        input.setDeptno(60);
        input.setDname("JAVA�а�");
        input.setLoc("���а�");

        // 3) ������ ���� --> ���ϰ��� ����� ���� ��
        System.out.println(input);
        int output = sqlSession.insert("Mapper.insertItem", input);

        // 4) ��� �Ǻ�
        System.out.println(output + "���� ������ �����");

        // 5) ������� ���� �� DB ���� ����
        sqlSession.commit();
        sqlSession.close();
    }
}
