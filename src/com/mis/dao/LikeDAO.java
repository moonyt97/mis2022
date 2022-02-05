package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mis.domain.LikeVO;
import com.mis.domain.StoreVO;

import util.DBManager;

public class LikeDAO {
	private LikeDAO() {

	}

	private static LikeDAO instance = new LikeDAO();

	public static LikeDAO getInstance() {
		return instance;
	}

	public int addLike(LikeVO lVo) {

		int result = -1;

		String sql = "INSERT INTO TBL_LIKE VALUES(SYSDATE,?,?)";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lVo.getStoreNo());
			pstmt.setString(2, lVo.getMemberId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	public int countLike(String storeNo) {

		int count = 0;
		String sql = "SELECT COUNT(LIKE_DATE) FROM TBL_LIKE WHERE STORE_NO=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeNo);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				count = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return count;

	}

	public boolean isLike(String storeNo, String memberId) {

		boolean res = false;
		String sql = "SELECT * FROM TBL_LIKE WHERE STORE_NO=? AND MEMBER_ID = ?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, storeNo);
			pstmt.setString(2, memberId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				res = true;
			} else {
				res = false;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		System.out.println(res);
		return res;

	}

	public int deleteLike(LikeVO lVo) {

		int result = -1;

		String sql = "DELETE FROM TBL_LIKE WHERE STORE_NO=? AND MEMBER_ID=?";

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBManager.getConnection();

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, lVo.getStoreNo());
			pstmt.setString(2, lVo.getMemberId());
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt);
		}
		return result;
	}

	
}
