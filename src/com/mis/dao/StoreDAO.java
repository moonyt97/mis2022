package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mis.domain.StoreVO;

import util.DBManager;

public class StoreDAO {

	private StoreDAO() {

	}

	private static StoreDAO instance = new StoreDAO();

	public static StoreDAO getInstance() {
		return instance;
	}

	public ArrayList<StoreVO> getdedukguStoreList() {

		ArrayList<StoreVO> list = new ArrayList<StoreVO>();

		String sql = "SELECT * FROM TBL_STORE WHERE STORE_LO='대덕구'";

		Connection conn = DBManager.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				StoreVO store = new StoreVO();

				store.setStoreTitle(rs.getString("STORE_TITLE"));
				store.setStoreNo(rs.getString("STORE_NO"));
				store.setStoreContent(rs.getString("STORE_CONTENT"));
				store.setStoreDate(rs.getString("STORE_DATE"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreLo(rs.getString("STORE_LO"));
				store.setMemberId(rs.getString("MEMBER_ID"));
				list.add(store);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	public ArrayList<StoreVO> getdongguStoreList() {

		ArrayList<StoreVO> list = new ArrayList<StoreVO>();

		String sql = "SELECT * FROM TBL_STORE WHERE STORE_LO='동구'";
		Connection conn = DBManager.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				StoreVO store = new StoreVO();

				store.setStoreTitle(rs.getString("STORE_TITLE"));
				store.setStoreNo(rs.getString("STORE_NO"));
				store.setStoreContent(rs.getString("STORE_CONTENT"));
				store.setStoreDate(rs.getString("STORE_DATE"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreLo(rs.getString("STORE_LO"));
				store.setMemberId(rs.getString("MEMBER_ID"));
				list.add(store);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	public ArrayList<StoreVO> getjungguStoreList() {

		ArrayList<StoreVO> list = new ArrayList<StoreVO>();

		String sql = "SELECT * FROM TBL_STORE WHERE STORE_LO='중구'";

		Connection conn = DBManager.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				StoreVO store = new StoreVO();

				store.setStoreTitle(rs.getString("STORE_TITLE"));
				store.setStoreNo(rs.getString("STORE_NO"));
				store.setStoreContent(rs.getString("STORE_CONTENT"));
				store.setStoreDate(rs.getString("STORE_DATE"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreLo(rs.getString("STORE_LO"));
				store.setMemberId(rs.getString("MEMBER_ID"));
				list.add(store);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}
	
	public ArrayList<StoreVO> getseoguStoreList() {

		ArrayList<StoreVO> list = new ArrayList<StoreVO>();

		String sql = "SELECT * FROM TBL_STORE WHERE STORE_LO='서구'";

		Connection conn = DBManager.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				StoreVO store = new StoreVO();

				store.setStoreTitle(rs.getString("STORE_TITLE"));
				store.setStoreNo(rs.getString("STORE_NO"));
				store.setStoreContent(rs.getString("STORE_CONTENT"));
				store.setStoreDate(rs.getString("STORE_DATE"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreLo(rs.getString("STORE_LO"));
				store.setMemberId(rs.getString("MEMBER_ID"));
				list.add(store);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}
	
	public ArrayList<StoreVO> getyusungguStoreList() {

		ArrayList<StoreVO> list = new ArrayList<StoreVO>();

		String sql = "SELECT * FROM TBL_STORE WHERE STORE_LO='유성구'";

		Connection conn = DBManager.getConnection();
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			rs = stmt.executeQuery(sql);

			while (rs.next()) {

				StoreVO store = new StoreVO();

				store.setStoreTitle(rs.getString("STORE_TITLE"));
				store.setStoreNo(rs.getString("STORE_NO"));
				store.setStoreContent(rs.getString("STORE_CONTENT"));
				store.setStoreDate(rs.getString("STORE_DATE"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreLo(rs.getString("STORE_LO"));
				store.setMemberId(rs.getString("MEMBER_ID"));
				list.add(store);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}

		return list;
	}

	public int insertStore(StoreVO sVo) {

		int result = -1;

		String sql = "INSERT INTO TBL_STORE VALUES(SEQ_TBL_STORE.Nextval,?,?,?,?,sysdate,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sVo.getStoreTitle());
			pstmt.setString(2, sVo.getStoreLo());
			pstmt.setString(3, sVo.getStoreContent());
			pstmt.setString(4, sVo.getStoreImg());
			pstmt.setString(5, sVo.getMemberId());

			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	public StoreVO storeDetail(String storeNo) {
		StoreVO store = null;

		String sql = "SELECT * FROM TBL_STORE WHERE STORE_NO=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeNo);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				store = new StoreVO();
				store.setStoreTitle(rs.getString("STORE_TITLE"));
				store.setStoreNo(rs.getString("STORE_NO"));
				store.setStoreContent(rs.getString("STORE_CONTENT"));
				store.setStoreDate(rs.getString("STORE_DATE"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreLo(rs.getString("STORE_LO"));
				store.setMemberId(rs.getString("MEMBER_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return store;
	}

	public int updateStore(StoreVO sVo) {
		int result = -1;

		String sql = "UPDATE TBL_STORE SET STORE_TITLE=?, STORE_CONTENT=?, STORE_IMG=? WHERE STORE_NO=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, sVo.getStoreTitle());
			pstmt.setString(2, sVo.getStoreContent());
			pstmt.setString(3, sVo.getStoreImg());
			pstmt.setString(4, sVo.getStoreNo());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}

		return result;
	}

	public int deleteStore(String storeNo) {
		int result = -1;

		String sql = "DELETE FROM TBL_STORE WHERE STORE_NO=?";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeNo);

			result = pstmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();

		} finally {

			DBManager.close(conn, pstmt);

		}

		return result;
	}
	public ArrayList<StoreVO> getLikeList(String memberId) {

		ArrayList<StoreVO> list = new ArrayList<StoreVO>();

		String sql = "SELECT * FROM TBL_STORE WHERE STORE_NO IN (SELECT STORE_NO FROM TBL_LIKE WHERE MEMBER_ID=?)";

		Connection conn = DBManager.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();
			while (rs.next()) {

				StoreVO store = new StoreVO();

				store.setStoreTitle(rs.getString("STORE_TITLE"));
				store.setStoreNo(rs.getString("STORE_NO"));
				store.setStoreContent(rs.getString("STORE_CONTENT"));
				store.setStoreDate(rs.getString("STORE_DATE"));
				store.setStoreImg(rs.getString("STORE_IMG"));
				store.setStoreLo(rs.getString("STORE_LO"));
				store.setMemberId(rs.getString("MEMBER_ID"));
				list.add(store);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}

		return list;
	}

}
