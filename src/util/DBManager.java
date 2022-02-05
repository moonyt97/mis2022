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
			// (1�ܰ�) JDBC ����̹� �ε�
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// (2�ܰ�) �����ͺ��̽� ���� ��ü Connection ����
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

	// select ���� �� ���ҽ� ������ ���� �޼ҵ�
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

	// insert, update, delete �۾� ���� �� ���ҽ� ������ ���� �޼ҵ�
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
