package com.mis.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.MemberDAO;

/**
 * Servlet implementation class IdcheckServlet
 */
@WebServlet("/Idcheck.do")
public class IdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdcheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// ���̵� �ߺ� üũ �� ������ ���
				String memberid = request.getParameter("memberId");
				
				// ���̵� �ߺ�üũ Ȯ��
				MemberDAO  dao = MemberDAO.getInstance();
				int result = dao.confirmID(memberid);
				
				// ���̵� �ߺ� üũ ��� �Ӽ� ������ ����
				request.setAttribute("memberid", memberid);
				request.setAttribute("result", result);
				
				// ������ �̵�
				RequestDispatcher dispatcher = request.getRequestDispatcher("member/idcheck.jsp");
				dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
