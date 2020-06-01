<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%
		//이번엔 jsp ->servlet 26-1실습은 반대였음
		request.setAttribute("id", "abcde");
		request.setAttribute("pw", "12345");
		response.sendRedirect("RequestObj");
		//sendRedirect메소드가 HttpServletResponse객체에 있는거
	%>
</body>
</html>