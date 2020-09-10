<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>test1</h1>
<h3>data1 : ${requestScope.dataBean.data1 }</h3>	
주입받은 bean을 request영역에 어떠한 이름으로 저장할 것인지를 지정해주지 않으면,
자동으로 클래스의 이름 -첫글자는 소문자로 해서 request영역에 저장되게 된다.
<h3>data2 : ${requestScope.dataBean.data2 }</h3>
</body>
</html>