<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
login
<c:if test="${not empty pageContext.request.userPrincipal }">
<p>Login successed</p>
</c:if>
<c:if test="${empty pageContext.request.userPrincipal }">
<p>is Logouted</p>
</c:if>
User id : ${pageContext.request.userPrincipal.name }<br/>
<a href="${pageContext.request.contextPath}/j_spring_security_logout">LogOut</a><br/>
</body>
</html>