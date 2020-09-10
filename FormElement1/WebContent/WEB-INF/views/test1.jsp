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
	<h1>test1</h1>
	<form:form modelAttribute="dataBean" action="result">	<!-- method기본값은 post, action기본값은 현재페이지, id기본값은 command, modelAttribute설정 해줄시 id는 modelAttribute값  -->
		<form:hidden path="a1"/>	<!-- dataBean객체안의 a1을 넣어주고, id와 name도 a1으로 설정이 된다. value에는 dataBean이라는 이름으로 저장되어있는 객체의 a1에 들어있는 값을 가져와서 바인딩해준다.-->
		text : <form:input path="a2"/><br>
		password : <form:password path="a3" showPassword="true"/><br> <!-- showPassword="true"를 넣어주면 password가 들어가게 되고, 페이지속성에서 볼수도 있다.(showPassword를 아예 안넣어주면 아예 안나옴) -->
		textarea : <form:textarea path="a4"/>
		<form:button disabled="true">확인버튼</form:button>	<!-- <button type="submit" value="Submit">이렇게 설정이 된다. -->
	</form:form>
</body>
</html>