<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3</h1>
	<h3>data1 : ${requestScope.data1 }</h3>
	model객체는 HttpServletRequest를 확장한 것이라 requestScope로 scope설정이 가능하다.
	<h3>data2 : ${data2 }</h3>
</body>
</html>