<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@ page import ="java.util.Enumeration" %>
<%@ page import = "com.oreilly.servlet.*"%>
<!-- ���� ���̺귯���� �ٿ���� ���̺귯�� -->
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<% 
	String path = request.getRealPath("fileFolder");
	//getRealPath��� �Լ��� ��¥ �ּҸ� ������ �� �ִ�.
	int size = 1024*1024*10;//10M;
	String file ="";	//���� �ø� ���� �̸�
	String oriFile = "";//�̸��� ���� ������ ������ �� �����ؼ� �����ϴ� original �����̸�
	
	try{
		MultipartRequest multi = new MultipartRequest(request,path,size,"EUC-KR",new DefaultFileRenamePolicy());
		//�����ڿ� ���� ����(request, ��ġ(path), ����ũ��(size), �����̸� ������(euc-kr),���� �̸��� ������ ���ö� ��� �Ұ����� ó�����ִ� ��(new DefaultFileRenamePolicy()))
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
	<!-- ���ŽἭ �ٸ��� �غô�~ -->
</body>
</html>