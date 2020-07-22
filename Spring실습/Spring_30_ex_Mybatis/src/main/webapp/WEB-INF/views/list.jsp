<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<tr>
		<td>number</td>
		<td>Writer</td>
		<td>Content</td>
		<td>Delete</td>
	</tr>
	<c:forEach items="${list}" var="dto">
	<tr>
		<td>${dto.mId}</td>
		<td>${dto.mWriter}</td>
		<td>${dto.mContent}</td>
		<td><a href="delete?mId=${dto.mId}">X</a></td>
	</c:forEach>
</table>
<p><a href = "writeForm">go to write</a></p>
</body>
</html>