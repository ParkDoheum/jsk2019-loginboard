<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.hkit.loginboard.vo.*" %>
<%@ page import="java.util.*" %>
<%	
	UserVO vo = (UserVO) session.getAttribute("loginUser");	
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("list"); 
%>    
<div>
<% 
if(vo != null) {
	out.print(vo.getNm() + "님 환영합니다.");	
}
%>
</div>
<div>
	<table>
		<tr>
			<th>no</th>
			<th>제목</th>
			<th>등록일</th>
			<th>작성자</th>
		</tr>
		<% for(BoardVO item : list) {	%>
		<tr>
			<td><%=item.getI_board() %></td>
			<td><%=item.getTitle() %></td>
			<td><%=item.getRdate() %></td>
			<td><%=item.getUser_nm() %></td>
		</tr>
		<% } %>
	</table>
</div>	
<div>
	<% if(vo != null) { %>
		<a href="boardReg"><button>글등록</button></a>
	<% } %>
</div>