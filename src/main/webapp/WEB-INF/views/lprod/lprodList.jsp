<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="kr.or.ddit.student.model.StudentVo"%>
<%@page import="java.util.List"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
</head>

<body>

	<%@include file="../common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">

			<%@include file="../common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">LPROD</h2>
						<div class="table-responsive">
							<h3>상품코드조회</h3>
							<table class="table table-striped">
								<tr>
									<td><h4>상품ID</h4></td>
									<td><h4>상품코드</h4></td>
									<td><h4>상품이름</h4></td>
								</tr>
								<c:forEach var="lprod" items="${lprodPageList}">
									<tr>
										<td>${lprod.lprod_id}</td>
										<td>${lprod.lprod_gu}</td>
										<td>${lprod.lprod_nm}</td>
									</tr>
								</c:forEach>

							</table>
						</div>

						<a class="btn btn-default pull-right">상품 등록</a>

						<div class="text-center">
							<ul class="pagination">
								 <%=(String) request.getAttribute("pageNavi")%> 
									<!-- test객체를 연습하기위해 service에서 처리하도록 한다. -->
							<%--		int pagingnationSize = (Integer)request.getAttribute("pagingnationSize");
									for(int i =1;i<=pagingnationSize;i++){
										out.write("<li><a href=\"/studentList?page="+i+"&pageSize=10\">"+i+"</a></li>");
									}
								
								 <c:set var="prev" value="${page-1}"/>
								<c:if test="${page eq '1'}">
									<c:set var="prev" value="${page}"/>
								</c:if>
								 <li><a href="lprodList?page=${prev}&pageSize=10" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
								<c:forEach begin="1" end="${pagingnationSize}" var="i">
									<c:set var="pageClass" value=""/>
									<c:if test="${page eq i}">
										<c:set var="pageClass" value="class=\"active\""/>										
									</c:if>
									<li ${pageClass}><a href="/lprodList?page=${i}&pageSize=10">${i}</a></li>
								</c:forEach>
								<c:set var="next" value="${page+1}"/>
								<c:if test="${page eq pagingnationSize}">
									<c:set var="next" value="${page}"/>
								</c:if>
								<li><a href="lprodList?page=${next}&pageSize=10" aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li> --%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>