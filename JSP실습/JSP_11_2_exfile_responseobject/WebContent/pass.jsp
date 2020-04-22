<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%!
		int age;
	%>
	<%
		String str = request.getParameter("age");
		age = Integer.parseInt(str);
	%>
	성인입니다 쌉가능
	<a href = "requestex.html">처음으로 이동</a>
</body>
</html>