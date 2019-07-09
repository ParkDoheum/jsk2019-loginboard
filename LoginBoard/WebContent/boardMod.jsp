<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.loginboard.vo.*" %>    
<%
	BoardVO vo = (BoardVO)request.getAttribute("vo");
%>    
<form action="boardMod" method="post">	
	<input type="hidden" name="i_board" value="<%=vo.getI_board()%>">
	제목 : <input type="text" name="title" value="<%=vo.getTitle()%>"><br>
	내용 : <textarea rows="10" cols="70" name="content"><%=vo.getContent()%></textarea>
	<input type="submit" value="수정">
</form>