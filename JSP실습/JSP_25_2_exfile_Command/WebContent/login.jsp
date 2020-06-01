<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<%	if(session.getAttribute("VaildMem")!=null){%> <!-- vailmem은 현재 로그인 되어있는지 확인할 수 있는 변수고 되있으면 밑의 로그인 과정을 거칠 필요가 없으니 main으로 보냄 -->
	<jsp:forward page = "main.jsp"></jsp:forward>
<% }%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action = "loginOk.jsp" method = "post">
		아이디 : <input type="text" name="id" value="<% if(session.getAttribute("id")!=null) out.println(session.getAttribute("id"));%>"><br/>
		비밀번호 : <input type="password" name = "pw"> <br/>
		<input type = "submit" value="로그인">&nbsp;&nbsp;<input type= "button" value = "회원가입" onclick = "javascript:window.location='join.jsp'"> <!-- onclick은 클릭하면 어떠한 동작을 하게끔하고 여기서의 동작은 새로운 페이지 만들어서 회원가입 페이지 이동해준다는 것 -->
		
	</form>
</body>
</html>