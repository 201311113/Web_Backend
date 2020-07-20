<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
loginform

<form action="<c:url value="j_spring_security_check"/>" method="post">
	<c:if test="${param.ng != null }">
	<p>
		Login Ng!<br/>
		<c:if test="${SPRING_SECURITY_LAST_EXCEPTION != NULL }">
			message : <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
		</c:if>
	</p>
	</c:if>
	id : <input type = "text" name="j_username"><br/>
	pw : <input type = "text" name="j_password"><br/>
	<input type = "submit" value="login"><br/>
</form>
</body>
</html>