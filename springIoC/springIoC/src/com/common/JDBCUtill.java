package com.common;

import java.sql.*;

public class JDBCUtill {
	public static Connection getConnection() {
		// TODO1. Connection ��ü�� �����ϴ� ������ �����Ͻÿ�.
		return null;
	}
	
	public static void close(PreparedStatement stmt, Connection conn) {
		// TODO2. Statement, Connection ��ü�� close�ϴ� ������ �����Ͻÿ�.
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		// TODO3. ResultSet, Statement, Connection ��ü�� close�ϴ� ������ �����Ͻÿ�.
	}
}
