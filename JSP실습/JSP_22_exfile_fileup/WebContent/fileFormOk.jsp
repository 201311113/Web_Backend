<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import ="java.util.Enumeration" %>
<%@ page import = "com.oreilly.servlet.*"%>
<!-- 위의 라이브러리가 다운받은 라이브러리 -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String path = request.getRealPath("fileFolder");
	//getRealPath라는 함수로 진짜 주소를 가져올 수 있다.
	int size = 1024*1024*10;//10M;
	String file ="";	//내가 올린 파일 이름
	String oriFile = "";//이름이 같은 파일을 덮어씌우는 걸 방지해서 존재하는 original 파일이름
	
	try{
		MultipartRequest multi = new MultipartRequest(request,path,size,"EUC-KR",new DefaultFileRenamePolicy());
		//생성자에 들어가는 변수(request, 위치(path), 파일크기(size), 파일이름 문자형(euc-kr),같은 이름의 파일이 들어올때 어떻게 할것인지 처리해주는 것(new DefaultFileRenamePolicy()))
		Enumeration files = multi.getFileNames();
		String str = (String)files.nextElement();
		
		file = multi.getFilesystemName(str);
		oriFile = multi.getOriginalFileName(str);
	}catch(Exception e){
		e.printStackTrace();
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<script language="JavaScript">
		alert("file upload success!");
		history.back();
	</script>
	<!-- 배운거써서 다르게 해봤당~ -->
</body>
</html>