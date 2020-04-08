package com.common;

import java.sql.*;

public class JDBCUtill {
	public static Connection getConnection() {
		// TODO1. Connection 객체를 리턴하는 구문을 구현하시오.
		return null;
	}
	
	public static void close(PreparedStatement stmt, Connection conn) {
		// TODO2. Statement, Connection 객체를 close하는 구문을 구현하시오.
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
		// TODO3. ResultSet, Statement, Connection 객체를 close하는 구문을 구현하시오.
	}
}
