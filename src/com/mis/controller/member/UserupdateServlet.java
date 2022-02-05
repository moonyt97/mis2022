package com.mis.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.MemberDAO;
import com.mis.domain.MemberVO;

/**
 * Servlet implementation class UserupdateServlet
 */
@WebServlet("/Userupdate.do")
public class UserupdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserupdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String memberid = request.getParameter("memberId");
		MemberDAO dao = MemberDAO.getInstance();
		
		MemberVO mVo = dao.getMember(memberid);
		request.setAttribute("mVo", mVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/memberUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ���� ����
				request.setCharacterEncoding("UTF-8");
			
				//ȸ�� ���� ���� �޾Ƽ� ������ ���
				String memberId = request.getParameter("memberId");
				String memberPw = request.getParameter("memberPw");
				String memberName = request.getParameter("memberName");
				String memberPhone = request.getParameter("memberPhone");
				
				// ������ MemberVO�� ���
				MemberVO mVo = new MemberVO();
				mVo.setMemberId(memberId);
				mVo.setMemberPw(memberPw);
				mVo.setMemberName(memberName);
				mVo.setMemberPhon(memberPhone);
				
				//DAO�� ���� ȸ�� ���
				MemberDAO dao = MemberDAO.getInstance();
				dao.updateMember(mVo);
				
				response.sendRedirect("Logout.do");
				
				
			}
	}


