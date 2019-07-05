<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글등록</title>
</head>
<body>
	<form action="boardReg" method="post">
		제목 : <input type="text" name="title"><br>
		내용 : <textarea rows="10" cols="70" name="content"></textarea>
		<input type="submit" value="등록">
	</form>
</body>
</html>