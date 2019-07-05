<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String msg = (String)request.getAttribute("msg");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="js/join.js"></script>
</head>
<body>
	<div>
		<form id="frm" action="join" method="post" onsubmit="return submitChk();">
			아이디 : <input type="text" name="id"><br>
			이름: <input type="text" name="nm"><br>
			비밀번호 : <input type="password" name="pw"><br>
			확인비밀번호 : <input type="password" name="repw"><br>			
			<input type="submit" value="회원가입">
			<input type="reset" value="다시적기">
		</form>
		<div>
			<% if(msg != null) { %>
				<span><%=msg %></span>
			<% } %>
		</div>		
	</div>
</body>
</html>






