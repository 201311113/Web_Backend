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
	//id�����ϸ� ����
%>
	<script language = "javascript">
		alert("���̵� �̹� ���� �մϴ�.");
		history.back();//�������� �ڷΰ��� �ѹ����ִ� script����Լ�
	</script>
<%
	}else{
		int ri = dao.insertMember(dto);
		if(ri ==memberDAO.MEMBER_JOIN_SUCCESS){
			session.setAttribute("id", dto.getId());
%>
		<script language = "javascript">
			alert("*****ȸ�������� �����մϴ�*****");
			document.location.href = "login.jsp";
		</script>			
<% 		}else{
	
%>
	<script language = "javascript">
		alert("ȸ�����Կ� �����߽��ϴ�");
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