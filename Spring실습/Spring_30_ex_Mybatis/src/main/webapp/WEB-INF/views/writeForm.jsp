<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
write.jsp<br/>
<table width="500" cellpadding="0" cellspacing="0" border="1">
	<form action="write" method="post">
		<tr>
			<td>writer</td>
			<td><input type = "text" name = "mWriter" size="50"></td>
		</tr>
		<tr>
			<td>content</td>
			<td><input type ="text" name ="mContent" size="150"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="submit">
		</tr>
	</form>
</table>
</body>
</html>