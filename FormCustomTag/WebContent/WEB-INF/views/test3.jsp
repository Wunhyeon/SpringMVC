<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Test3</h1>
	<form:form modelAttribute="testBean" action='result'>
		이름 : <form:input path="user_name"/><br>
		아이디 : <form:input path="user_id"/><br>
		비밀번호 : <form:password path="user_pw" /><br>		<!-- showPassword="true"를 해주게 되면 비밀번호에도 값이 들어가고 f12누르면 확인가능하게 된다. -->
		우편번호 : <form:input path="user_postcode"/><br>
		주소1 : <form:input path="user_address1"/><br>
		주소2 : <form:input path="user_address2"/><br>
		<form:button type="submit">확인</form:button>
	</form:form>
</body>
</html>