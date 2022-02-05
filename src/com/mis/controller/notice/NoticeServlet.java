package com.mis.controller.notice;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.dao.NoticeDAO;
import com.mis.domain.NoticeVO;


/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/Notice.do")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		ArrayList<NoticeVO> list = NoticeDAO.getInstance().getNoticeList();
				request.setAttribute("list", list);
				String url = "member/login.jsp";
				
				HttpSession session = request.getSession();
				if(session.getAttribute("loginUser") != null){
					url = "notice/notice.jsp";
				}
				RequestDispatcher dispatcher = request.getRequestDispatcher(url);
				dispatcher.forward(request, response);
			}
				


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<NoticeVO> list = NoticeDAO.getInstance().getNoticeList();
		request.setAttribute("list", list);
		String url = "member/login.jsp";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null){
			url = "notice/notice.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	}

