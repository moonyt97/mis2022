package com.mis.controller.yusunggu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mis.dao.StoreDAO;
import com.mis.domain.StoreVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class UpdatedetailServlet
 */
@WebServlet("/yusungguUpdatedetail.do")
public class YuSungGuUpdatedetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YuSungGuUpdatedetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String storeNo = request.getParameter("num");
		StoreDAO dao = StoreDAO.getInstance();
		StoreVO sVo = dao.storeDetail(storeNo);
		request.setAttribute("sVo", sVo);
		RequestDispatcher dispatcher = request.getRequestDispatcher("yusunggu/detailUpdate.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String realFolder = "";
		int maxSize = 410 * 410 * 5;
		String encType = "UTF-8";
		String savefile = "img";
		ServletContext scontext = getServletContext();
		realFolder = scontext.getRealPath(savefile);
		MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());

		// 회원 가입 정보 받아서 변수에 담기
		String storeTitle = multi.getParameter("storeTitle");
		String storeContent = multi.getParameter("storeContent");
		String storeImg = multi.getFilesystemName("storeImg");
		String storeNo = multi.getParameter("storeNo");

		// 변수를 MemberVO로 담기
		StoreVO sVo = new StoreVO();
		sVo.setStoreTitle(storeTitle);
		sVo.setStoreContent(storeContent);
		sVo.setStoreImg("/" + savefile + "/" + storeImg);
		sVo.setStoreNo(storeNo);

		StoreDAO dao = StoreDAO.getInstance();
		dao.updateStore(sVo);

		response.sendRedirect("YuSungGu.do");
	}
}
