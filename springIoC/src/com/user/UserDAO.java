package com.user;

import java.sql.*;
import com.common.JDBCUtil;
import com.user.UserVO;
import org.springframework.stereotype.Component;


// TODO1. UserDAO 클래스를 Bean으로 등록하는 적절한 Annotation을 설정하시오.
@Component("userDao")
public class UserDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		// TODO2. 특정 id와 password에 해당하는 User정보를 검색하여 리턴하는 코드를 구현하시오.
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
