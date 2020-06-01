<%@page import="com.javalec.daoto.memberDAO"%>
<%@ page import = "java.sql.Timestamp" %>
<%@ page import = "com.javalec.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% request.setCharacterEncoding("EUC-KR"); %>
<jsp:useBean id="dto" class="com.javalec.daoto.memberDTO"></jsp:useBean>
<jsp:setProperty name="dto" property="*"/>
<%
	dto.setRDate(new Timestamp(System.currentTimeMillis()));
	memberDAO dao = memberDAO.getInstance();
	if(dao.confirmId(dto.getId()) == memberDAO.MEMBER_EXISTENT){
	//id존재하면 실패
%>
	<script language = "javascript">
		alert("아이디가 이미 존재 합니다.");
		history.back();//브라우저를 뒤로가기 한번해주는 script언어함수
	</script>
<%
	}else{
		int ri = dao.insertMember(dto);
		if(ri ==memberDAO.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id", dto.getId());
%>
		<script language = "javascript">
			alert("*****회원가입을 축하합니다*****");
			document.location.href = "login.jsp";
		</script>			
<% 		}else{
	
%>
	<script language = "javascript">
		alert("회원가입에 실패했습니다");
		document.location.href = "login.jsp";
	</script>
<% 		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>