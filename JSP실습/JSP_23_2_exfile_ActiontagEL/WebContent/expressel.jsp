<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member" class = "com.javalec.el.MemberInfo"></jsp:useBean>
<jsp:setProperty name = "member" property="name" value="박무성"/>
<jsp:setProperty name = "member" property="id" value="antjddlekd"/>
<jsp:setProperty name = "member" property="pw" value="antjddl123"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	이름 : <jsp:getProperty name = "member" property="name"/><br/>
	아이디 : <jsp:getProperty name = "member" property="id"/>
	비밀번호 : <jsp:getProperty name="member" property="pw"/>
<hr/>
	<!-- 위는 액션태그 제대로 다쓴것 -->
	이름:${member.name}<br/>
	아이디 : ${member.id }<br/>
	비밀번호 : ${member.pw }<br/>
	<!-- 아래는 액션태그 el로 표현한것 -->
</body>
</html>