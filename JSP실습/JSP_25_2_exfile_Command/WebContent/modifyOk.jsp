<%@ page import = "com.javalec.daoto.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="dto" class = "com.javalec.daoto.memberDTO" scope = "page"></jsp:useBean>>
<jsp:setProperty name ="dto" property = "*"/>
<%
	String id = (String)session.getAttribute("id");
	dto.setId(id);
	memberDAO dao = memberDAO.getInstance();
	int ri = dao.updateMember(dto);
	if(ri == 1){
%>
	<script language = "javascript">
		alert("정보수정 되었습니다");
		document.location.href = "main.jsp";
	</script>
<%
	}else{
%>
	<script language = "javascript">
		alert("정보수정 실패");
		history.go(-1);
	</script>
<%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>