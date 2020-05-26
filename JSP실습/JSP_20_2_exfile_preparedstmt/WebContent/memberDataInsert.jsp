<%@ page import = "java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%!
	Connection connection;
	PreparedStatement prestatement;
	ResultSet resultSet;
	
	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:ORCL4";
	String uid = "scott";
	String upw = "tiger";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	
	<%
		try{
			Class.forName(driver);
			connection =DriverManager.getConnection(url,uid,upw);
			int n;
			String query = "insert into memberforpre (id,pw,name,phone) values(?,?,?,?)";
			prestatement = connection.prepareStatement(query);
			
			prestatement.setString(1,"abc");
			prestatement.setString(2, "123");
			prestatement.setString(3, "박무성");
			prestatement.setString(4, "01077996317");
			
			n= prestatement.executeUpdate();
			
			prestatement.setString(1, "def");
			prestatement.setString(2, "456");
			prestatement.setString(3, "유수빈");
			prestatement.setString(4, "01072704637");
			
			n=prestatement.executeUpdate();
		
			prestatement.setString(1, "army");
			prestatement.setString(2, "bts");
			prestatement.setString(3, "방탄");
			prestatement.setString(4, "01086861234");
			
			n=prestatement.executeUpdate();
			
			prestatement.setString(1, "refresh");
			prestatement.setString(2, "825");
			prestatement.setString(3, "굳잡");
			prestatement.setString(4, "0116852268");
			
			n=prestatement.executeUpdate();
			if(n==1){
				out.println("insert success");
			}else{
				out.println("insert fail");
			}
		}catch (Exception e){e.printStackTrace();
		}finally{
			try{
				if(resultSet != null) resultSet.close();
				if(prestatement != null) prestatement.close();
				if(connection != null) connection.close();
			} catch(Exception e){}

			
		}
	%>
	
	<a href = "memberDataView.jsp"> 회원정보 보기</a>
</body>
</html>