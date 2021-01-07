<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ page import="com.javaex.vo.GuestVo" %>

<%
	GuestVo guestVo = (GuestVo)request.getAttribute("Delete");
	
    /*
	System.out.println("====deleteForm=====");
	System.out.println(guestVo);
    */
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/guestbook2/gbc" method="get">
		비밀번호: <input type="password" name="password">
		<button type="submit">확인</button>
		<input type="hidden" name="no" value="<%=guestVo.getNo() %>"> 
		<input type="hidden" name="action" value="delete">
	</form>
	
	<a href="/guestbook2/gbc?action=addList"></a>
	
</body>
</html>