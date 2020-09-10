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
		AssertTrue<br>
		data1 : <form:radiobutton path="data1" value="true"/>true<br>
				<form:radiobutton path="data1" value="false"/>false<br>
				<form:errors path="data1"></form:errors>
		<hr>
		AssertFalse<br>
		data2 : <form:radiobutton path="data2" value="true"/>true<br>
				<form:radiobutton path="data2" value="false"/>false<br>
				<form:errors path="data2"></form:errors>
		<hr>
		max<br>
		data3 : <form:input path="data3"/><br>
				<form:errors path="data3"></form:errors><br>
		<hr>
		DecimalMax<br>
		data4 : <form:input path="data4"/><br>
				<form:errors path="data4"></form:errors>
		<hr>
		Null<br>
		data5 : <form:checkbox path="data5" value="check1"/>
				<form:errors path="data5"></form:errors>
		<hr>
		NotNull<br>
		data6 : <form:checkbox path="data6" value="check1"/>
				<form:errors path="data6"></form:errors>
		<hr>
		Digits<br>
		data7 : <form:input path="data7"/>
				<form:errors path="data7"></form:errors>
		<hr>
		Size<hr>
		data8 : <form:input path="data8"/>
				<form:errors path="data8"></form:errors>
		<hr>
		Pattern<hr>
		data9 : <form:input path="data9"/>
				<form:errors path="data9"/>
		
		<form:button type="submit">확인</form:button>
		
		
	</form:form>
</body>
</html>