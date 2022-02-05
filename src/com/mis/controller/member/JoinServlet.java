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
 * Servlet implementation class JoinServlet
 */
@WebServlet("/Join.do")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public JoinServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("member/join.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String memberId = request.getParameter("memberId");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		String memberAdmin = request.getParameter("memberAdmin");

		// ������ MemberVO�� ���
		MemberVO mVo = new MemberVO();
		mVo.setMemberId(memberId);
		mVo.setMemberPw(memberPw);
		mVo.setMemberName(memberName);
		mVo.setMemberPhon(memberPhone);
		mVo.setMemberAdmin(Integer.parseInt(memberAdmin));

		MemberDAO dao = MemberDAO.getInstance();
		int result = dao.insertMember(mVo);

		if (result == 1) {
			request.setAttribute("memberid", memberId);
			request.setAttribute("message", "회원가입이 되었습니다.");
		} else {
			request.setAttribute("message", "회원가입이 실패하였습니다.");
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("Login.do");
		dispatcher.forward(request, response);

	}
}
