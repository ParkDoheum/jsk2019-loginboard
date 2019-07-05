<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.loginboard.vo.*" %>
<%	
	UserVO vo = (UserVO) session.getAttribute("loginUser");	
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div>
	<% 
	if(vo != null) {
		out.print(vo.getNm() + "님 환영합니다.");	
	}
	%>
	</div>
	<div>
		<% if(vo != null) { %>
			<a href="boardReg"><button>글등록</button></a>
		<% } %>
	</div>	
</body>
</html>