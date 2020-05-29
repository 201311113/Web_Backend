<%@ page import = "com.javalec.daoto.*" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%
	request.setCharacterEncoding("EUC-KR");
	
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	
	memberDAO dao = memberDAO.getInstance();//dao객체생성해서
	int checkNum = dao.userCheck(id, pw);//유저가 있는지 비밀번호가 맞는지 체크해봄
	if(checkNum == -1){
%>
	<script language = "javascript">
		alert("아이디가 존재하지 않습니다");
		history.go(-1); //이거도 뒤로 가는 건가봄
	</script>
<%
	}else if(checkNum == 0){
%>
	<script language = "javascript">
		alert("비밀번호가 틀렸습니다");
		history.go(-1);
	</script>
<%
	}else if(checkNum == 1){
		memberDTO dto = dao.getMember(id);
		if(dto == null){ //한번검사했지만 예외처리
%>	
	<script language = "javascript">
		alert("존재하지 않는 회원입니다");
		history.go(-1);
	</script>
<%
		}else{
			String name = dto.getName();
			session.setAttribute("id", id);
			session.setAttribute("name", name);
			session.setAttribute("ValidMem", "yes");
			response.sendRedirect("main.jsp");
		}//회원조회가 성공했다면 session에 값올려서 로그인 상태라는 것을 유지하게하고 main으로 페이지를 보냄
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