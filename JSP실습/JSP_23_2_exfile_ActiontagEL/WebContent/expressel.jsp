<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<jsp:useBean id="member" class = "com.javalec.el.MemberInfo"></jsp:useBean>
<jsp:setProperty name = "member" property="name" value="�ڹ���"/>
<jsp:setProperty name = "member" property="id" value="antjddlekd"/>
<jsp:setProperty name = "member" property="pw" value="antjddl123"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�̸� : <jsp:getProperty name = "member" property="name"/><br/>
	���̵� : <jsp:getProperty name = "member" property="id"/>
	��й�ȣ : <jsp:getProperty name="member" property="pw"/>
<hr/>
	<!-- ���� �׼��±� ����� �پ��� -->
	�̸�:${member.name}<br/>
	���̵� : ${member.id }<br/>
	��й�ȣ : ${member.pw }<br/>
	<!-- �Ʒ��� �׼��±� el�� ǥ���Ѱ� -->
</body>
</html>