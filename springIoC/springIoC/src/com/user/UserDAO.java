package com.user;

import java.sql.*;
import com.common.JDBCUtil;


public class UserDAO {
	// TODO1. UserDAO 클래스를 Bean으로 등록하는 적절한 Annotation을 설정하시오.
	public class UserDAO {
		private Connection conn;
		private PreparedStatement stmt;
		private ResultSet rs;
		public UserVO getUser(UserVO vo) {
			UserVO user = null;
			// TODO2. 특정 id와 password에 해당하는 User정보를 검색하여 리턴하는 코드를 구현하시오.
			return user;
		}
	}
}
