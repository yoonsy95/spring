package study.java.test;

import org.apache.ibatis.session.SqlSession;

import study.java.mybatis.MyBatisConnectionFactory;
import study.java.model.Dept;

public class SelectOne {
    public static void main(String[] args) {
        // 1) �����ͺ��̽� ����
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) ��ȸ�� ������ (null�� ����� ���� �������� �ʴ´�)
        Dept input = new Dept();
        input.setDeptno(10);

        // 3) ������ ��ȸ
        Dept output = sqlSession.selectOne("Mapper.selectItem", input);

        // 4) ��� �Ǻ�
        if (output == null) {
            System.out.println("��ȸ��� ����");
        } else {
            System.out.println(output.toString());
        }

        // 5) DB ���� ����
        sqlSession.close();
    }
}
