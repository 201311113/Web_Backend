<%@ page import = "com.javalec.daoto.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	memberDAO dao = memberDAO.getInstance();//dao��ü�����ؼ�
	int checkNum = dao.userCheck(id, pw);//������ �ִ��� ��й�ȣ�� �´��� üũ�غ�
	if(checkNum == -1){
%>
	<script language = "javascript">
		alert("���̵� �������� �ʽ��ϴ�");
		history.go(-1); //�̰ŵ� �ڷ� ���� �ǰ���
	</script>
<%
	}else if(checkNum == 0){
%>
	<script language = "javascript">
		alert("��й�ȣ�� Ʋ�Ƚ��ϴ�");
		history.go(-1);
	</script>
<%
	}else if(checkNum == 1){
		memberDTO dto = dao.getMember(id);
		if(dto == null){ //�ѹ��˻������� ����ó��
%>	
	<script language = "javascript">
		alert("�������� �ʴ� ȸ���Դϴ�");
		history.go(-1);
	</script>
<%
		}else{
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
		}//ȸ����ȸ�� �����ߴٸ� session�� ���÷��� �α��� ���¶�� ���� �����ϰ��ϰ� main���� �������� ����
	}
%>
<!--

//-->
</script>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>