<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<c:set var="vatName" value = "varValue"/>
	vatName : <c:out value="${vatName }"/>
	<br/>
	<!-- 변수에 값 집어넣고 빼기 -->
	<c:remove var="vatName"/>
	vatName : <c:out value="${vatName }"/></h3>
	<hr/>
	
	<c:catch var="error">
		<%=2/0 %>
	</c:catch>
	<!-- 에러 검출후 출력 -->
	<br/>
	<c:out value="${error }"/>
	<hr/>
	
	
	<c:if test="${1+2==3 }">
		correct
	</c:if>
	<!-- if문 사용 -->
	<hr/>
	
	<c:forEach var="fEach" begin="0" end="30" step="3">
		${fEach }
	</c:forEach>
	<!-- 반복문 사용 -->
</body>
</html>