package com.mis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mis.domain.MemberVO;

import util.DBManager;

public class MemberDAO {
	//1) �����ڸ� private ����
		private MemberDAO(){
			
		}
		
		//3) ��ü���� ��ü ����
		private static MemberDAO instance = new MemberDAO();
		
		//3) �ٸ� class���� ��� �� �� �ִ� public��  method ����
		public static MemberDAO getInstance(){
			return instance;
		}
		
	public ArrayList<MemberVO> getMemberList(){
			
			ArrayList<MemberVO> list = new ArrayList<MemberVO>();
			
			//���� �� ���� ����
			String sql = "SELECT * FROM TBL_MEMBER";
			
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
					MemberVO member = new MemberVO();
					
					//4-2) rs ��� setting
					member.setMemberId(rs.getString("MEMBER_ID"));
					member.setMemberPw(rs.getString("MEMBER_PW"));
					member.setMemberName(rs.getString("MEMBER_NAME"));
					member.setMemberPhon(rs.getString("MEMBER_PHONE"));
					member.setMemberAdmin(rs.getInt("MEMBER_ADMIN"));
					
					//4-3) arrayList�� ���
					list.add(member);
					
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				DBManager.close(conn, stmt, rs);
			}
			
			return list;
		}
	
	public int userCheck(String memberid, String pw){
		int result = -1;
		String sql="SELECT MEMBER_PW FROM TBL_MEMBER WHERE MEMBER_ID=? AND MEMBER_PW=?";
		
		//1) �����ͺ��̽� ���� ��ü ����
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//2) �����ͺ��̽� ����
			conn = DBManager.getConnection();
			
			//3-1) PreparedStatement ��ü ����(������ ���� ����)
			pstmt = conn.prepareStatement(sql);
			//3-2) ������ ����(? ����ǥ�ε� ���� ���� ������ ��ü)
			pstmt.setString(1, memberid);
			pstmt.setString(2,pw);
			//3-3) ���� ���� �� ��� rs�� ���
			rs = pstmt.executeQuery();
			
			//4)�α��� ���� Ȯ��(rs ����� ������ �α��� ���� �ƴϸ� ����)
			if(rs.next()){
				result = 0;
			}else{
				result=-1;
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5) ���ҽ� ����
			DBManager.close(conn, pstmt, rs);
		}
		
		
		return result;
	}
public MemberVO getMember(String memberid){
		
		MemberVO mVo= null;
		
		String sql = "SELECT * FROM TBL_MEMBER WHERE MEMBER_ID=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//2) �����ͺ��̽� ����
			conn = DBManager.getConnection();
			
			//3-1) PreparedStatement ��ü ����(������ ���� ����)
			pstmt = conn.prepareStatement(sql);
			//3-2) ������ ����(? ����ǥ�ε� ���� ���� ������ ��ü)
			pstmt.setString(1, memberid);
			
			//3-3) ���� ���� �� ��� rs�� ���
			rs = pstmt.executeQuery();
			
			//4)����� Ȯ�� �� VO�� ��� 
			if(rs.next()){
				
				//4-1) MemberVO ��ü ����
				mVo = new MemberVO();
				
				//4-2) rs ��� setting
				mVo.setMemberId(rs.getString("MEMBER_ID"));
				mVo.setMemberPw(rs.getString("MEMBER_PW"));
				mVo.setMemberName(rs.getString("MEMBER_NAME"));
				mVo.setMemberPhon(rs.getString("MEMBER_PHONE"));
				mVo.setMemberAdmin(rs.getInt("MEMBER_ADMIN"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//5) ���ҽ� ����
			DBManager.close(conn, pstmt, rs);
		}
		
		return mVo;
		
	}
public int confirmID(String memberid){
	
	int result = -1;
	String sql = "SELECT MEMBER_ID FROM TBL_MEMBER WHERE UPPER(MEMBER_ID)=UPPER(?)";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	try {
		//2) �����ͺ��̽� ����
		conn = DBManager.getConnection();
		
		//3-1) PreparedStatement ��ü ����(������ ���� ����)
		pstmt = conn.prepareStatement(sql);
		//3-2) ������ ����(? ����ǥ�ε� ���� ���� ������ ��ü)
		pstmt.setString(1, memberid);
		
		//3-3) ���� ���� �� ��� rs�� ���
		rs = pstmt.executeQuery();
		
		//4)����� ID Ȯ�� �� result �� ó��
		if(rs.next()){
			// �̹� ��� �� ID
			result = 1;
		}else{
			// ��� ���� �� ID
			result=-1;
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		//5) ���ҽ� ����
		DBManager.close(conn, pstmt, rs);
	}
	
	
	return result;
	
}
public int insertMember(MemberVO mVo){
	
	int result = -1;
	
	String sql = "INSERT INTO TBL_MEMBER VALUES(?,?,?,?,?)";
	
	// 1) �����ͺ��̽� ���� ��ü ����
	Connection conn = null;
	PreparedStatement pstmt = null;
	try {
		//2) �����ͺ��̽� ����
		conn = DBManager.getConnection();
		
		//3-1) PreparedStatement ��ü ����(������ ���� ����)
		pstmt = conn.prepareStatement(sql);
		//3-2) ������ ����(? ����ǥ�ε� ���� ���� ������ ��ü)
		pstmt.setString(1, mVo.getMemberId());
		pstmt.setString(2, mVo.getMemberPw());
		pstmt.setString(3, mVo.getMemberName());
		pstmt.setString(4, mVo.getMemberPhon());
		pstmt.setInt(5, mVo.getMemberAdmin());
		
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
public int updateMember(MemberVO mVo){
	int result =-1;
	
	String sql = "UPDATE TBL_MEMBER SET MEMBER_PW=?, MEMBER_NAME=?, MEMBER_PHONE=? WHERE MEMBER_ID=?";
	
	// 1) �����ͺ��̽� ���� ��ü ����
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				//2) �����ͺ��̽� ����
				conn = DBManager.getConnection();
				
				//3-1) PreparedStatement ��ü ����(������ ���� ����)
				pstmt = conn.prepareStatement(sql);
				//3-2) ������ ����(? ����ǥ�ε� ���� ���� ������ ��ü)
				pstmt.setString(1, mVo.getMemberPw());
				pstmt.setString(2, mVo.getMemberName());
				pstmt.setString(3, mVo.getMemberPhon());
				pstmt.setString(4, mVo.getMemberId());
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

	
	
}
