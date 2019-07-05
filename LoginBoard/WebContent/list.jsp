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
		<button>등록</button>
	</div>
	list.jsp	
</body>
</html>