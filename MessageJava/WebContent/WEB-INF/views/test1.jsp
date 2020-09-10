<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1</h1>
	<h3>aaa.a1 : <spring:message code="aaa.a1"></spring:message></h3>
	<h3>bbb.b1 : <spring:message code="bbb.b1"></spring:message></h3>
	<h3>aaa.a2 : <spring:message code="aaa.a2" arguments="${args }"></spring:message></h3>
	<h3>aaa.a3 : <spring:message code="aaa.a3"></spring:message> </h3>	<!-- //java코드에는 locale을 넣어줘야 하지만(Ststem.out.println()으로 찍어볼때) -->
																			 <!-- 여기에는 locale을 안넣어 줘도 알아서 인식 -->
</body>
</html>