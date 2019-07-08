<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String title = (String)request.getAttribute("title");
	String view = (String)request.getAttribute("view");
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
		
		</header>
		<section>
			<jsp:include page="<%=view %>"/>
		</section>
		<footer>
		
		</footer>
	</div>	
</body>
</html>