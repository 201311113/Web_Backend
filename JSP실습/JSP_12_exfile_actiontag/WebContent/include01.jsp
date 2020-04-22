<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1>include01.jsp입니다.</h1>
	<jsp:include page="include02.jsp" flush="true"/>
	<h1>다시 include01입니다.</h1>
</body>
</html>