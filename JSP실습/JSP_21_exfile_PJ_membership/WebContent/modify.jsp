<%@ page import = "com.javalec.daoto.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<%
	String id= (String)session.getAttribute("id");
	memberDAO dao = memberDAO.getInstance();
	memberDTO dto = dao.getMember(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<script language = "JavaScript" src = "members.js"></script>
<!-- ���Ⱑ members.js�� ����ɰ������� �� -->
<title>Insert title here</title>
</head>
<body>
	<form action = "modifyOk.jsp" method = "post" name = "reg_frm">
		���̵� : <%= dto.getId() %><br/>
		��й�ȣ : <input type = "password" name = "pw" size="20"><br/>
		��й�ȣ Ȯ�� : <input type = "password" name= "pw_check" size="20"><br/> 
		�̸� : <%= dto.getName() %><br/>
		���� : <input type = "text" name= "eMail" size="20" value = <%=dto.getEMail() %> ><br/>
		�ּ� : <input type = "text" name = "address" size="20" value = <%=dto.getAddress() %>><br/>
		<input type ="button" value = "���� " onclick = "updateInfoConfirm()"> &nbsp;&nbsp; <input type ="reset" value="���" onclick = "javascript:window.location='login.jsp'">
	</form>
</body>
</html>