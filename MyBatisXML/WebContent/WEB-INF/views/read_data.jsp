<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:forEach items="${requestScope.list }" var="aa">
		${aa.data1 }, ${aa.data2 }, ${aa.data3 }<br>
	</c:forEach>
</body>
</html>