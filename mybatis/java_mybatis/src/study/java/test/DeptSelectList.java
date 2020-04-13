package study.java.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import study.java.model.Dept;
import study.java.mybatis.MyBatisConnectionFactory;

public class DeptSelectList {
    public static void main(String[] args) {
        // 1) �����ͺ��̽� ����
        SqlSession sqlSession = MyBatisConnectionFactory.getSqlSession();

        // 2) ������ ��ȸ
        // --> Mapper���� ������ ����ϰ� ���� �ʱ� ������ �Ķ���͸� ������ �ʿ䰡 ����.
        List<Dept> output = sqlSession.selectList("Mapper.selectList", null);

        // 4) ��� �Ǻ�
        if (output == null) {
            System.out.println("��ȸ��� ����");
        } else {
            for (Dept item: output) {
                System.out.println(item.toString());
            }
        }

        // 5) DB ���� ����
        sqlSession.close();
    }
}