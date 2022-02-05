package com.mis.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.dao.LikeDAO;
import com.mis.domain.LikeVO;
import com.mis.domain.MemberVO;

/**
 * Servlet implementation class LikeAddServlet
 */
@WebServlet("/LikeAdd.do")
public class LikeAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikeAddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String storeNo = request.getParameter("num");
		
		HttpSession session = request.getSession();
		MemberVO mVo = (MemberVO) session.getAttribute("loginUser");
		
		LikeVO lVo = new LikeVO();
		lVo.setMemberId(mVo.getMemberId());
		lVo.setStoreNo(Integer.parseInt(storeNo));
		
		LikeDAO dao = LikeDAO.getInstance();
		dao.addLike(lVo);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("dedukgustoreDetail.do");
		dispatcher.forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
