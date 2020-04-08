package com.common;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtil {
	public static Connection getConnection() {
		// TODO1. Connection 객체를 리턴하는 구문을 구현하시오.
		Connection conn = null;
		Properties prop = new Properties();
		
		try {
			prop.load(new FileInputStream("c://TEMP//dbinfo.properties"));
			Class.forName(prop.getProperty("driver"));
			
			conn=DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"), prop.getProperty("pwd"));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	public static void close(PreparedStatement pstmt, Connection conn) {
		try {
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(conn!=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
