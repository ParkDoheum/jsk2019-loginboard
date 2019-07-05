<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	
	String i_user = (String) session.getAttribute("i_user");
	System.out.println("i_user : " + i_user);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	list.jsp
	로그인 i_user : <%=i_user %>
</body>
</html>