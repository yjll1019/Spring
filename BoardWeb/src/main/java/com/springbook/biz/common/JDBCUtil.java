package com.springbook.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//모든 DAO 클래스에서 공통으로 사용할 connection 획득, 해제 작업을 위한 JDBCUtil 클래스!

public class JDBCUtil {
	
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");//드라이버 클래스 객체 생성, 등록
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test", "sa","");
			//매개변수 (데이터베이스 url, user, password)순
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void close(PreparedStatement stmt, Connection conn) {
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	
	public static void close(ResultSet rs,PreparedStatement stmt, Connection conn) {
		
		if(rs != null) {
			try {
				if(!rs.isClosed()) rs.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				rs = null;
			}
		}
		
		if(stmt != null) {
			try {
				if(!stmt.isClosed()) stmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				stmt = null;
			}
		}
		
		if(conn != null) {
			try {
				if(!conn.isClosed()) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				conn = null;
			}
		}
	}
	

}
