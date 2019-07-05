package kr.hkit.loginboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.loginboard.dao.BoardDAO;
import kr.hkit.loginboard.vo.BoardVO;
import kr.hkit.loginboard.vo.UserVO;

@WebServlet("/boardReg")
public class BoardRegSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO vo = (UserVO)session.getAttribute("loginUser");
		System.out.println("i_user : " + vo.getI_user());
		
		int i_user = vo.getI_user();
		if(i_user == 0) {
			response.sendRedirect("list");
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("boardReg.jsp");
			rd.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserVO userVO = (UserVO)session.getAttribute("loginUser");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		
		BoardVO vo = new BoardVO();		
		vo.setTitle(title);
		vo.setContent(content);
		vo.setI_user(userVO.getI_user());
		
		int result = BoardDAO.insertBoard(vo);		
		response.sendRedirect("list");
	}
}









