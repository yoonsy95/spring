package com.user;

import java.sql.*;
import com.common.JDBCUtil;


public class UserDAO {
	// TODO1. UserDAO Ŭ������ Bean���� ����ϴ� ������ Annotation�� �����Ͻÿ�.
	public class UserDAO {
		private Connection conn;
		private PreparedStatement stmt;
		private ResultSet rs;
		public UserVO getUser(UserVO vo) {
			UserVO user = null;
			// TODO2. Ư�� id�� password�� �ش��ϴ� User������ �˻��Ͽ� �����ϴ� �ڵ带 �����Ͻÿ�.
			return user;
		}
	}
}
