<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@include file="../common/jquery.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<spring:message code="userId"/> : <input type="text" name="userId"><br>
	<spring:message code="password"/> : <input type="text" name="password"><br>
	
	<h3>localeChange</h3>
	<form id="frm" action="/locale/view">
		<select id="selectBox" name="Language">
				<option>언어선택</option>
			<c:forEach items="${localeMap}" var="locale">
				<option value="${locale.key}">${locale.value}</option>	
			</c:forEach>
		</select>
	</form>
</body>
	<script type="text/javascript">
		$(function(){
			$("#selectBox").change(function(){
				$("#frm").submit();
			});
			
		});
	</script>
</html>