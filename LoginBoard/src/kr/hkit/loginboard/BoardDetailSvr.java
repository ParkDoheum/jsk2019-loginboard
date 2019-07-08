package kr.hkit.loginboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.loginboard.dao.BoardDAO;
import kr.hkit.loginboard.vo.BoardVO;

@WebServlet("/boardDetail")
public class BoardDetailSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i_board = request.getParameter("i_board");
		BoardVO vo = BoardDAO.getBoard(i_board);
		request.setAttribute("vo", vo);		
		
		request.setAttribute("title", "디테일");
		request.setAttribute("view", "boardDetail.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("temp.jsp");
		rd.forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
