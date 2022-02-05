package com.mis.controller.notice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.NoticeDAO;
import com.mis.domain.NoticeVO;

/**
 * Servlet implementation class DeDukGuDeleteServlet
 */
@WebServlet("/NoticeDelete.do")
public class NoticeDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String noticeNo = request.getParameter("noticeNo");
      NoticeVO nVo = new NoticeVO();
      nVo.setNoticeNo(noticeNo);
      NoticeDAO dao = NoticeDAO.getInstance();
      dao.deleteNotice(noticeNo);
      response.sendRedirect("Notice.do");
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      String noticeNo = request.getParameter("noticeNo");
      NoticeVO nVo = new NoticeVO();
      nVo.setNoticeNo(noticeNo);
      NoticeDAO dao = NoticeDAO.getInstance();
      dao.deleteNotice(noticeNo);
      response.sendRedirect("Notice.do");
   }

}