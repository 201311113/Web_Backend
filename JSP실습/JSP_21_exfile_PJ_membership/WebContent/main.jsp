<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	//예외처리
	if(session.getAttribute("ValidMem")==null){
%>
	<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
	//세션값에 저장되있는 정보값을 사용하기 위해 가져오는 것
	String name = (String)session.getAttribute("name");
	String id = (String)session.getAttribute("id");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<h1><%= name %> 님안녕하세요.</h1><br/>
	<form action = "logout.jsp" method="post">
		<input type = "submit" value = "로그아웃">&nbsp;&nbsp;&nbsp;<input type="button" value = "정보수정" onclick = "javascript:window.location = 'modify.jsp'">
	</form>
</body>
</html>