<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2</h1>
	<h3>data1 : ${requestScope.data1 }</h3> 
	requestScope에 담겨져 있는 거니깐 requestScope를 썼다. 
	requestScope는 생략가능하다. 그래도 나중에 유지보수할 때 편하기 위해 써주는 편이 좋다.
	만약 index에서 바로 ?로 get방식으로 넘겨줄 때는 param.으로 받아주면 된다.
	<h3>data2 : ${data2 }</h3>
</body>
</html>