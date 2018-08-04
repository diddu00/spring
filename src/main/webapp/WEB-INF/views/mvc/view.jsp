<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	/WEB-INF/views/mvc/view.jsp		:	${boardNum}<br>
	
	<form action="/mvc/requestParam" method="get">
		<input type="text" name="std_id" value="conny">
		<input type="submit" value="전송">
	</form>
	
	 <c:forEach items="${boardList}" var="board">
  		 ${board}<br>
  	 </c:forEach>
	
</body>
</html>