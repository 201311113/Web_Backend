<%@page import="java.util.ArrayList" %>
<%@page import = "com.javalec.daotoex.*" %>
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
		MemberDAO memberDAO = new MemberDAO();
		ArrayList<MemberDTO> dtos = memberDAO.memberSelect();
		
		for(int i=0;i<dtos.size();i++){
			MemberDTO dto = dtos.get(i);
			String name=dto.getName();
			String id=dto.getId();
			String pw=dto.getPw();
			String phone=dto.getPhone1()+"-"+dto.getPhone2()+"-"+dto.getPhone3();
			String gender=dto.getGender();
			
			out.println("이름 : "+name+", 아이디 : "+id+", 패스워드 : "+pw+", 전화번호 : "+phone+", 성별 : "+gender);
		}
	%>

</body>
</html>