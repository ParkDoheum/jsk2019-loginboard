package kr.hkit.loginboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.loginboard.dao.BoardDAO;
import kr.hkit.loginboard.vo.BoardVO;
import kr.hkit.loginboard.vo.UserVO;

@WebServlet("/boardDel")
public class BoardDelSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		UserVO loginUser = (UserVO)request.getSession().getAttribute("loginUser");
		String i_board = request.getParameter("i_board");
		if(loginUser == null) {
			response.sendRedirect("boardDetail?err=1&i_board=" + i_board);
			return;
		} 
		
		BoardVO vo = new BoardVO();
		vo.setI_user(loginUser.getI_user());
		vo.setI_board(Integer.parseInt(i_board));
		
		int result = BoardDAO.delBoard(vo);
		
		if(result == 0) { //디테일			
			//리다이렉트
			response.sendRedirect("boardDetail?err=1&i_board=" + i_board);

		} else { //리스트
			response.sendRedirect("list");
		}
	}
}
