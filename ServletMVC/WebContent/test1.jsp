<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1.mvc</h1>
	<h3>result : ${result }</h3><br>
	<h3>result : ${result }</h3><br>
	<h3>result : ${result }</h3><br>
	<h3>result : ${result }</h3><br>
	<h3>result : ${result }</h3><br>
	<h3>result : ${result }</h3><br>
	<h3>result : ${result }</h3><br>
	
	<%
		request.setCharacterEncoding("utf-8");
		String rs1 = request.getParameter("data1");
		out.write("rs1 : " + rs1);
		String rs2 = request.getAttribute("result").toString();
		out.write("rs2 : " + rs2);
		int rs3 = Integer.parseInt(rs2);
		out.write("rs3 :"+ rs3);
		
	%>
	<br>
	
	
</body>
</html>