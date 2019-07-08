package kr.hkit.loginboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.loginboard.dao.BoardDAO;
import kr.hkit.loginboard.vo.BoardVO;

@WebServlet("/list")
public class ListSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<BoardVO> list = BoardDAO.selectListBoard();
		request.setAttribute("list", list);
		
		request.setAttribute("title", "리스트");
		request.setAttribute("view", "list.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("temp.jsp");
		rd.forward(request, response);
	}

}
