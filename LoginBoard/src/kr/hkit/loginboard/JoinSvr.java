package kr.hkit.loginboard;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.loginboard.dao.UserDAO;
import kr.hkit.loginboard.vo.UserVO;

@WebServlet("/join")
public class JoinSvr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("join.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String nm = request.getParameter("nm");
		String pw = request.getParameter("pw");
		
		System.out.println("id : " + id);
		System.out.println("nm : " + nm);
		System.out.println("pw : " + pw);
		
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setNm(nm);
		vo.setPw(pw);
		
		int result = UserDAO.joinMember(vo);
		if(result == 0) {		//회원가입 실패
			request.setAttribute("msg", "회원가입에 실패하였습니다.");
			doGet(request, response);
		} else { //회원가입 성공
			response.sendRedirect("login");
		}
	}
}










