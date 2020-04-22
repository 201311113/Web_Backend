<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="forward_param.jsp">
		<jsp:param name="id" value="abcdefgh"/>
		<jsp:param name="pw" value="1q2w3e4r"/>
	</jsp:forward>
</body>
</html>