<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
createPage.jsp
<br/>
<!-- 1.stdCreate 2.stdUtilCreate 3.stdAnotationCreate -->
<form action = "stdUtilCreate">
	이름 : <input type = "text" name = "name" value = ${std.name} ><br/>
	아이디 : <input type = "text" name = "id" value = ${std.id }><br/>
	<input type = "submit" value = "전송"><br/>
</form>
</body>
</html>