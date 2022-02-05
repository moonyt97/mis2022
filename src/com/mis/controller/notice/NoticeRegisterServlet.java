package com.mis.controller.notice;

import java.io.IOException;

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
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/noticeRegister.do")
public class NoticeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "login.jsp";
		
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null){
			url = "notice/noticeRegister.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�ѱ� ���� ����
				request.setCharacterEncoding("UTF-8");
			
				//ȸ�� ���� ���� �޾Ƽ� ������ ���
				String noticeTitle = request.getParameter("noticeTitle");
				String noticeContent = request.getParameter("noticeContent");
				String noticeNo = request.getParameter("noticeNo");
				String noticeDate = request.getParameter("noticeDate");
				String memberId = request.getParameter("memberId");
				
				// ������ MemberVO�� ���
				NoticeVO nVo = new NoticeVO();
				nVo.setNoticeTitle(noticeTitle);
				nVo.setNoticeContent(noticeContent);
				nVo.setNoticeNo(noticeNo);
				nVo.setNoticeDate(noticeDate);
				nVo.setMemberId(memberId);
						
						
				//DAO�� ���� ȸ�� ���
				NoticeDAO dao = NoticeDAO.getInstance();
				int result = dao.insertNotice(nVo);
				
				//ȸ�� ���� ����� ������ �̵�
				if(result == 1){
					//ȸ�� ���� ����
					request.setAttribute("message", "�� ��Ͽ� �����Ͽ����ϴ�.");
				}else{
					request.setAttribute("message", "�� ��Ͽ� ���� �߽��ϴ�.");
				}
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("Notice.do");
				dispatcher.forward(request, response);
				
			}

	}


