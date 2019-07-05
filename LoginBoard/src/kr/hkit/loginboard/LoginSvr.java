package kr.hkit.loginboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.loginboard.dao.UserDAO;
import kr.hkit.loginboard.vo.UserVO;

@WebServlet("/login")
public class LoginSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("pw : " + pw);
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPw(pw);
		
		int result = UserDAO.login(vo);
		switch(result) {
		case 0: //id없음
			request.setAttribute("msg", "아이디가 존재하지 않습니다.");
			doGet(request, response);
			break;
		case -1: //비밀번호 틀림
			request.setAttribute("msg", "비밀번호를 확인해 주세요.");
			doGet(request, response);
			break;
		default: //로그인
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", vo);
			
			response.sendRedirect("list");
			break;
		}
	}
}











