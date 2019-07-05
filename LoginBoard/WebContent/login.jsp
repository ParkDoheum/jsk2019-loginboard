<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	String msg = (String)request.getAttribute("msg");

	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	if(id == null) {
		id = "";
	}
	
	if(pw == null) {
		pw = "";
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<div>
		<form action="login" method="post" onsubmit="return submitChk();">
			아이디 : <input type="text" name="id" value="<%=id %>"><br>
			비밀번호 : <input type="password" name="pw" value="<%=pw %>"><br>
			<input type="submit" value="로그인">
		</form>
		<div>
			회원이 아니신가요? <a href="join">회원가입</a>
		</div>
		<div>
			<%
				if(msg != null) {
					out.print(msg);
				}
			%>
		</div>
	</div>
</body>
</html>



