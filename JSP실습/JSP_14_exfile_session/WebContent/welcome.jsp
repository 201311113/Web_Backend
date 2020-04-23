<%@page import = "java.util.Enumeration" %>
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
		Enumeration enumeration = session.getAttributeNames();//있는 session들 한번에 enumeration 벡터에 집어넣은거
		while(enumeration.hasMoreElements()){
			String sName = enumeration.nextElement().toString();
			String sValue = (String)session.getAttribute(sName).toString();
			if(sValue.equals("abcde")) out.println(sValue+"님 안녕하세요  <br/>");
			
		}
	%>
	<a href ="logout.jsp"> 로그아웃 </a>
</body>
</html>