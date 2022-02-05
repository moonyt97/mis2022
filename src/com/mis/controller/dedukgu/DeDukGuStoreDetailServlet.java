package com.mis.controller.dedukgu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.dao.LikeDAO;
import com.mis.dao.StoreDAO;
import com.mis.domain.StoreVO;
import com.mis.domain.LikeVO;
import com.mis.domain.MemberVO;

/**
 * Servlet implementation class StoreDetailServlet
 */
@WebServlet("/dedukgustoreDetail.do")
public class DeDukGuStoreDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeDukGuStoreDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeNo = request.getParameter("num");

		// 좋아요 유무를 알기 위한 사용자 정보 가져오기
		HttpSession session = request.getSession();
		MemberVO mVo = (MemberVO) session.getAttribute("loginUser");

		StoreDAO dao = StoreDAO.getInstance();
		StoreVO sVo = dao.storeDetail(storeNo);

		LikeDAO ldao = LikeDAO.getInstance();
		int countLike = ldao.countLike(storeNo);
		boolean isLike = ldao.isLike(storeNo, mVo.getMemberId());
		
		LikeVO lVo = new LikeVO();
		lVo.setMemberId(mVo.getMemberId());
		lVo.setStoreNo(Integer.parseInt(storeNo));
		lVo.setIslike(isLike);

		request.setAttribute("sVo", sVo);
		request.setAttribute("countLike", countLike);
		request.setAttribute("isLike", isLike);
		request.setAttribute("lVo", lVo);
		

		RequestDispatcher dispatcher = request.getRequestDispatcher("dedukgu/detail.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
