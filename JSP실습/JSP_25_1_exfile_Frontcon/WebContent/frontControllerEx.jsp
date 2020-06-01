<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<!-- 4개의 요청을 하나의 서블릿에서 해결되고 이러한 방식으로 줘도 다 간다 -->
	<a href = "insert.do"> insert </a>
	<hr/>
	<a href = "http://localhost:8181<%= request.getContextPath()%>/update.do">update</a>
	<hr/>
	<a href = "http://localhost:8181/JSP_25_1_exfile_Frontcon/select.do">select</a>
	<hr/>
	<a href = "<%=request.getContextPath()%>/delete.do">delete</a>
</body>
</html>