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

@WebServlet("/boardMod")
public class BoardModSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;
           
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String i_board = request.getParameter("i_board");
		
		BoardVO vo = null;
		String title = request.getParameter("title");
		
		if(title == null) { //디테일 화면에서 넘어옴
			vo = BoardDAO.getBoard(i_board);
		
		} else { //수정 실패에서 넘어옴			
			String content = request.getParameter("content");
			vo = new BoardVO();
			vo.setI_board(Integer.parseInt(i_board));
			vo.setTitle(title);
			vo.setContent(content);
		}
		
		request.setAttribute("vo", vo);
		
		request.setAttribute("title", "글수정");
		request.setAttribute("view", "boardMod.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("temp.jsp");
		rd.forward(request, response);			
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String i_board = request.getParameter("i_board");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		System.out.println("i_board : " + i_board);
		System.out.println("title : " + title);
		System.out.println("content : " + content);
		
		BoardVO vo = new BoardVO();
		vo.setI_board(Integer.parseInt(i_board));
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = BoardDAO.updBoard(vo);
		if(result == 1) { //good
			response.sendRedirect("boardDetail?i_board=" + i_board);
		
		} else { //bad
			request.setAttribute("msg", "수정을 할 수 없습니다.");
			doGet(request, response);
		}
		
	}
}









