package com.mis.controller.notice;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.NoticeDAO;
import com.mis.domain.NoticeVO;

/**
 * Servlet implementation class UpdatedetailServlet
 */
@WebServlet("/NoticeUpdateDetail.do")
public class NoticeUpdateDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String noticeNo = request.getParameter("num");
		NoticeDAO dao = NoticeDAO.getInstance();
		NoticeVO nVo = dao.noticeDetail(noticeNo);
		request.setAttribute("nVo", nVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("notice/detailUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		request.setCharacterEncoding("UTF-8");
		
		 //회원 가입 정보 받아서 변수에 담기
		String noticeTitle = request.getParameter("noticeTitle");
		String noticeContent = request.getParameter("noticeContent");
		String noticeNo = request.getParameter("noticeNo");
//		String noticeDate = request.getParameter("noticeDate");
		String memberId = request.getParameter("memberId");
		
		// 변수를 MemberVO로 담기
		NoticeVO nVo = new NoticeVO();
		nVo.setNoticeTitle(noticeTitle);
		nVo.setNoticeContent(noticeContent);
		nVo.setNoticeNo(noticeNo);
//		nVo.setNoticeDate(noticeDate);
		nVo.setMemberId(memberId);
		
		System.out.println(nVo);
				
		NoticeDAO dao = NoticeDAO.getInstance();
		dao.updateNotice(nVo);
		
		response.sendRedirect("Notice.do");
	}
}
