package com.mis.controller.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.dao.MemberDAO;
import com.mis.domain.MemberVO;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null){
			url = "index.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/login.jsp";
		
		String memberid = request.getParameter("memberId");
		String pw = request.getParameter("memberPw");
		
		MemberDAO dao = MemberDAO.getInstance();
		
		int result = dao.userCheck(memberid, pw);
		
		if(result==0){
			MemberVO mVo = dao.getMember(memberid);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mVo);
			url = "index.jsp";
			
		}else{
			request.setAttribute("message", "로그인이 되었습니다.");
		}
		RequestDispatcher dispathcer = request.getRequestDispatcher(url);
		dispathcer.forward(request, response);
	}

}


