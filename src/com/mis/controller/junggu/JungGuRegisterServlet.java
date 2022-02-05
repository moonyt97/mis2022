package com.mis.controller.junggu;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mis.dao.StoreDAO;
import com.mis.domain.StoreVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/jungguregister.do")
public class JungGuRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JungGuRegisterServlet() {
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
			url = "junggu/register.jsp";
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
			
				String realFolder = "";
				int maxSize = 410 * 410 * 5;
				String encType = "UTF-8";
				String savefile = "img";
				ServletContext scontext = getServletContext();
				realFolder = scontext.getRealPath(savefile);
				MultipartRequest multi = new MultipartRequest(request, realFolder, maxSize, encType,
						new DefaultFileRenamePolicy());

				// 회원 가입 정보 받아서 변수에 담기
//					      String storeNo = request.getParameter("storeNo");
				String storeTitle = multi.getParameter("storeTitle");
				String storeContent = multi.getParameter("storeContent");
				String storeLo = multi.getParameter("storeLo");
				String storeImg = multi.getFilesystemName("storeImg");
//					      String storeDate = request.getParameter("storeDate");
				String memberId = multi.getParameter("memberId");

				// 변수를 MemberVO로 담기
				StoreVO sVo = new StoreVO();
//					      sVo.setStoreNo(storeNo);
				sVo.setStoreTitle(storeTitle);
				sVo.setStoreContent(storeContent);
				sVo.setStoreLo(storeLo);
				sVo.setStoreImg("/" + savefile + "/" + storeImg);
				sVo.setMemberId(memberId);
//					      sVo.setStoreDate(storeDate);

				// DAO를 통해 회원 등록
				StoreDAO dao = StoreDAO.getInstance();
				int result = dao.insertStore(sVo);

				// 회원 가입 결과로 페이지 이동
				if (result == 1) {
					// 회원 가입 성공
					request.setAttribute("message", "글 등록에 성공하였습니다.");
				} else {
					request.setAttribute("message", "글 등록에 실패 했습니다.");
				}

				RequestDispatcher dispatcher = request.getRequestDispatcher("JungGu.do");
				dispatcher.forward(request, response);
			}

	}


