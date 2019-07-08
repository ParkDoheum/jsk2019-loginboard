<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.loginboard.vo.*" %>
<%	
	UserVO userVO = (UserVO) session.getAttribute("loginUser");
	BoardVO boardVO = (BoardVO) request.getAttribute("vo");	
%>

<div>
	제목 : <%=boardVO.getTitle() %> (<%=boardVO.getRdate() %>)<br>
	글쓴이 : <%=boardVO.getUser_nm() %><br>
	내용 : <%=boardVO.getContent() %>	
</div>
<div>
	<% if(userVO != null && userVO.getI_user() == boardVO.getI_user()) {%>
		<button>수정</button>
		<button>삭제</button>	
	<% } %>
</div>