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
	<h1>input_data</h1>
	<form:form action="input_pro" modelAttribute="dataBean1" method="post">
	NotEmpty<br>
	data1 : <form:input type="text" path="data1"/><br>
			<%-- <form:errors path="data1"></form:errors> --%>
	<hr>
	NotBlank<br>
	data2 : <form:input path="data2" type="text"/><br>
			<form:errors path="data2"></form:errors>
	<hr>
	Positive<br>
	data3 : <form:input path="data3" type="text"/><br>	<!-- 사실 type설정 안해줘도 된다. 안해주면 디폴트로 text로 설정됨. -->
			<form:errors path="data3"></form:errors>
	<hr>
	PositiveOrZero<br>
	data4 : <form:input path="data4" type="text"/><br>
			<form:errors path="data4"/>
	<hr>
	Negative<br>
	data5 : <form:input path="data5"/><br>
			<form:errors path="data5"></form:errors>
	<hr>
	NegativeOrZero<br>
	data6 : <form:input path="data6"/><br>
			<form:errors path="data6"></form:errors>
	<hr>
	Email<br>
	data7 : <form:input path="data7"/>
			<form:errors path="data7"></form:errors>
		<form:button type="submit">확인</form:button>
	</form:form>
</body>
</html>