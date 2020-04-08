package com.user;

import java.sql.*;
import com.common.JDBCUtil;
import com.user.UserVO;
import org.springframework.stereotype.Component;


// TODO1. UserDAO Ŭ������ Bean���� ����ϴ� ������ Annotation�� �����Ͻÿ�.
@Component("userDao")
public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		// TODO2. Ư�� id�� password�� �ش��ϴ� User������ �˻��Ͽ� �����ϴ� �ڵ带 �����Ͻÿ�.
		String sql="select * from users where id=? and password=?";
		
		try {
			conn=JDBCUtil.getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			rs=pstmt.executeQuery();
			if(rs.next()) {
				user=new UserVO();
				user.setId(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, pstmt, conn);
		}
		
		return user;
	}
}
