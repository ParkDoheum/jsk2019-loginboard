<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.loginboard.vo.*" %>    
<%
	String title = (String)request.getAttribute("title");
	String view = (String)request.getAttribute("view");
	
	UserVO loginUser = (UserVO)session.getAttribute("loginUser");
	
	//로그인 필수 페이지 (로그인이 안 되어 있으면 강제 리다이렉트)
	switch(view) {
	case "boardReg.jsp":
		if(loginUser == null) {
			response.sendRedirect("list");
		}
		break;
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%=title %></title>
<link rel="stylesheet" type="text/css" href="css/common.css">
</head>
<body>
	<div id="container">
		<header>
			<ul>
				<li><a href="list">리스트</a></li>				
				<% if(loginUser != null) { %>
					<li><a href="logout">로그아웃</a></li>
				<% } else { %>
					<li><a href="login">로그인</a></li>
				<% } %>	
			</ul>
		</header>
		<section>			
			<jsp:include page="<%=view %>"/>
		</section>
		<footer>
		
		</footer>
	</div>	
</body>
</html>