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
<!-- 여기가 members.js를 사용케가져오는 곳 -->
<title>Insert title here</title>
</head>
<body>
	<form action = "modifyOk.jsp" method = "post" name = "reg_frm">
		아이디 : <%= dto.getId() %><br/>
		비밀번호 : <input type = "password" name = "pw" size="20"><br/>
		비밀번호 확인 : <input type = "password" name= "pw_check" size="20"><br/> 
		이름 : <%= dto.getName() %><br/>
		메일 : <input type = "text" name= "eMail" size="20" value = <%=dto.getEMail() %> ><br/>
		주소 : <input type = "text" name = "address" size="20" value = <%=dto.getAddress() %>><br/>
		<input type ="button" value = "수정 " onclick = "updateInfoConfirm()"> &nbsp;&nbsp; <input type ="reset" value="취소" onclick = "javascript:window.location='login.jsp'">
	</form>
</body>
</html>