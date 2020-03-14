<%@page import="io.javabrains.springsecurityjpaImp.MyUserDetails"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h1>
		<%
			MyUserDetails user = (MyUserDetails) session.getAttribute("loginDetails");
		%>
	</h1>
	<h1>
		welcome to Index call ${message}
		<%
			if (user != null) {
				out.print(user.toString());
			}
		%>
	</h1>
	<c:out value="${message}"></c:out>
</body>
</html>