<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			아이디 : <input type="text" name="id"><br>
			비밀번호 : <input type="password" name="pw"><br>
			<input type="submit" value="로그인">
		</form>
		<div>
			회원이 아니신가요? <a href="join">회원가입</a>
		</div>
	</div>
</body>
</html>