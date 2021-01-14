<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page import="java.util.List" %>
<%@ page import="com.javaex.vo.GuestVo" %>

<%-- 
<%
	List<GuestVo> guestList = (List<GuestVo>)request.getAttribute("gList");

	/*
	System.out.println("====addList=====");
	System.out.println(guestList);
	*/
%>
 --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook2/gbc" method="get">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name"></td>
				<td>비밀번호</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td colspan="4"><textarea cols = 60 rows=5 name="content"></textarea></td>
			</tr>
			<tr>
				<td colspan="4"><button type="submit">등록</button></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="add">
	</form>
	<c:forEach items="${gList}" var="gl">  
		<table border="1">
			<tr>
				<td>${gl.no}</td>
				<td>${gl.name}</td>
				<td>${gl.regDate}</td>
				<td><a href="/guestbook2/gbc?action=dform&no=${gl.no}">삭제</a></td>
			</tr> <!-- 이것만 40분 찾음.. 다시 만들어 볼 때 실수하지 않기-->
			<tr>
				<td colspan="4">${gl.content}</td>
			</tr>
		</table>
	</c:forEach>
	
</body>
</html>