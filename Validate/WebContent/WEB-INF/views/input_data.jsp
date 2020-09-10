<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>input_data</h1>
<form action="input_pro" method="post">
	data1 : <input type="text" name="data1"><br>
	<spring:hasBindErrors name="dataBean1">
		<c:if test="${errors.hasFieldErrors('data1') }">
			${errors.getFieldError('data1').defaultMessage }
		</c:if>
	</spring:hasBindErrors>	
	<!-- dataBean1이라는 얘한테 문제가 있는가 물어보는 것. 만약에 그 문제가  data1이라는 프로퍼티에 있는가.문제가 있다면 그 메시지를 출력해라 -->
	<!-- Controller에서 input_pro매핑부분에 BindingResult를 주입받았다. 여기에는 유효성 검사에 위배가되는 정보들이 들어가있다. 
	이 정보들이 request영역에 errors라는 이름으로 담겨져서 jsp에 전달된다. 그래서 그걸 가지고 사용하는 것. -->
	data2 : <input type="text" name="data2"><br>
	
	<spring:hasBindErrors name="dataBean1">
		<c:if test="${errors.hasFieldErrors('data2') }">
			${errors.getFieldError('data2').defaultMessage }
		</c:if>
	</spring:hasBindErrors>
	
	
	<button type="submit">확인</button>
</form>

</body>
</html>