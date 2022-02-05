package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager {

	public static Connection getConnection() {

		Connection conn = null;

		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String user = "MIS2022_DMT1";
		String password = "1234";

		try {
			// (1단계) JDBC 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// (2단계) 데이터베이스 연결 객체 Connection 생성
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;

	}

	// select 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt, ResultSet rs) {

		try {
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// insert, update, delete 작업 수행 후 리소스 해제를 위한 메소드
	public static void close(Connection conn, Statement stmt) {

		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
