package kr.hkit.loginboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/boardReg")
public class BoardRegSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String i_user = (String)session.getAttribute("i_user");
		System.out.println("i_user : " + i_user);
		
		if(i_user == null || i_user.equals("")) {
			response.sendRedirect("list");
			
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("boardReg.jsp");
			rd.forward(request, response);	
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
