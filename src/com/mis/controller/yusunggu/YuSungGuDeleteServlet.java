package com.mis.controller.yusunggu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.StoreDAO;
import com.mis.domain.StoreVO;

/**
 * Servlet implementation class DeDukGuDeleteServlet
 */
@WebServlet("/YuSungGuDelete.do")
public class YuSungGuDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public YuSungGuDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String storeNo = request.getParameter("storeNo");
		StoreVO sVo = new StoreVO();
		sVo.setStoreNo(storeNo);
		StoreDAO dao = StoreDAO.getInstance();
		dao.deleteStore(storeNo);
		response.sendRedirect("YuSungGu.do");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String storeNo = request.getParameter("storeNo");
		StoreVO sVo = new StoreVO();
		sVo.setStoreNo(storeNo);
		StoreDAO dao = StoreDAO.getInstance();
		dao.deleteStore(storeNo);
		response.sendRedirect("YuSungGu.do");
	}

}