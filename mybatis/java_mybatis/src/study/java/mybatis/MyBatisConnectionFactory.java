package study.java.mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
    /** �����ͺ��̽� ���� ��ü */
    // import org.apache.ibatis.session.SqlSessionFactory;
    private static SqlSessionFactory sqlSessionFactory;

    /** XML�� ��õ� ���� ������ �о���δ�. */
    // Ŭ���� �ʱ�ȭ �� : Ŭ���� ������ ������ �ʱ�ȭ�� ���ȴ�.
    // Ŭ������ ó�� �ε��� �� �ѹ��� ����ȴ�.
    static {
        // ���� ������ ����ϰ� �ִ� XML�� ��� �б�
        // --> import java.io.Reader;
        // --> import org.apache.ibatis.io.Resources;
        try {
            // mybatis_config.xml ������ ��� ����
            Reader reader = Resources.getResourceAsReader("study/java/mybatis/mybatis_config.xml");

            // sqlSessionFactory�� �������� �ʴ´ٸ� �����Ѵ�.
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** �����ͺ��̽� ���� ��ü�� ���� DATABASE�� ������ ���Ǹ� �����Ѵ�. */
    // --> import org.apache.ibatis.session.SqlSession;
    public static SqlSession getSqlSession() {
        return sqlSessionFactory.openSession();
    }
}