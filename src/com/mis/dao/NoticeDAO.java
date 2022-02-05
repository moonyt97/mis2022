package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mis.domain.NoticeVO;

import util.DBManager;

public class NoticeDAO {
	//�̱��� ����(Singleton pattern) -> ��ü�� 1���� �����ؼ� ���
	
	//1) �����ڸ� private ����
	private NoticeDAO(){
		
	}
	
	//3) ��ü���� ��ü ����
	private static NoticeDAO instance = new NoticeDAO();
	
	//3) �ٸ� class���� ��� �� �� �ִ� public��  method ����
	public static NoticeDAO getInstance(){
		return instance;
	}
	
public ArrayList<NoticeVO> getNoticeList(){
		
		ArrayList<NoticeVO> list = new ArrayList<NoticeVO>();
		
		//���� �� ���� ����
		String sql = "SELECT * FROM TBL_NOTICE";
		
		//1) connection ��ü �޾ƿ���
		Connection conn = DBManager.getConnection();
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			//2) Statement ��ü �޾ƿ���
			stmt = conn.createStatement();
			
			//3) ���� ���� �� ��� �޾ƿ���
			rs = stmt.executeQuery(sql);
			
			//4) ����� �ϳ��� ���, ArrayList�� ���
			while(rs.next()){
				
				//4-1) MemberVO ����
				NoticeVO notice = new NoticeVO();
				
				//4-2) rs ��� setting
				notice.setNoticeNo(rs.getString("NOTICE_NO"));
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				notice.setNoticeDate(rs.getString("NOTICE_DATE"));
				notice.setMemberId(rs.getString("MEMBER_ID"));
				//4-3) arrayList�� ���
				list.add(notice);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}


public int insertNotice(NoticeVO nVo){
		
		int result = -1;
		
		String sql = "INSERT INTO TBL_NOTICE VALUES(SEQ_TBL_NOTICE.Nextval,?,?,sysdate,?)";
		
		// 1) �����ͺ��̽� ���� ��ü ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			//2) �����ͺ��̽� ����
			conn = DBManager.getConnection();
			
			//3-1) PreparedStatement ��ü ����(������ ���� ����)
			pstmt = conn.prepareStatement(sql);
			//3-2) ������ ����(? ����ǥ�ε� ���� ���� ������ ��ü)
			pstmt.setString(1, nVo.getNoticeTitle());
			pstmt.setString(2, nVo.getNoticeContent());
			pstmt.setString(3, nVo.getMemberId());
			
			//3-3) ���� ���� �� ��� result�� ��� (1: ����, 0:����)
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5) ���ҽ� ����
			DBManager.close(conn, pstmt);
		}
	
		return result;
		}

	public NoticeVO noticeDetail(String noticeNo){
		NoticeVO notice = null;
		
		String sql = "SELECT * FROM TBL_NOTICE WHERE NOTICE_NO=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =null;
		
		try {
			//2) Statement ��ü �޾ƿ���
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,noticeNo);
			//3) ���� ���� �� ��� �޾ƿ���
			rs = pstmt.executeQuery();
			//4) ���̸� ���
			if(rs.next()){
				notice = new NoticeVO();
				notice.setNoticeTitle(rs.getString("NOTICE_TITLE"));
				notice.setNoticeNo(rs.getString("NOTICE_NO"));
				notice.setNoticeContent(rs.getString("NOTICE_CONTENT"));
				notice.setNoticeDate(rs.getString("NOTICE_DATE"));
				notice.setMemberId(rs.getString("MEMBER_ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBManager.close(conn, pstmt, rs);
		}
		
		return notice;
	}
	
	public int updateNotice(NoticeVO nVo){
		int result =-1;
		
		String sql = "UPDATE TBL_NOTICE SET NOTICE_TITLE=?, NOTICE_CONTENT=?, MEMBER_ID=?  WHERE NOTICE_NO=?";
		
		// 1) �����ͺ��̽� ���� ��ü ����
				Connection conn = null;
				PreparedStatement pstmt = null;
				try {
					//2) �����ͺ��̽� ����
					conn = DBManager.getConnection();
					
					//3-1) PreparedStatement ��ü ����(������ ���� ����)
					pstmt = conn.prepareStatement(sql);
					//3-2) ������ ����(? ����ǥ�ε� ���� ���� ������ ��ü)
					pstmt.setString(1, nVo.getNoticeTitle());
					pstmt.setString(2, nVo.getNoticeContent());
					pstmt.setString(3, nVo.getMemberId());
					pstmt.setString(4, nVo.getNoticeNo());
					//3-3) ���� ���� �� ��� result�� ��� (1: ����, 0:����)
					result = pstmt.executeUpdate();
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					//5) ���ҽ� ����
					DBManager.close(conn, pstmt);
				}
		
		return result;
	}
	
	public int deleteNotice(String noticeNo) {
	      int result = -1;

	      String sql = "DELETE FROM TBL_NOTICE WHERE NOTICE_NO=?";

	      Connection conn = null;
	      PreparedStatement pstmt = null;


	      try {

	         conn = DBManager.getConnection();

	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, noticeNo);

	         result = pstmt.executeUpdate(); 

	      } catch (SQLException e) {

	         e.printStackTrace();

	      } finally {

	         DBManager.close(conn, pstmt);

	      }
	      
	      return result;
	   }

}


