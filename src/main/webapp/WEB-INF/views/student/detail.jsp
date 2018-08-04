<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<link href="/css/common.css" rel="stylesheet">
</head>

<body>
	<%@include file="../common/top.jsp" %>
	<div class="container-fluid">
		<div class="row">

		<%@include file="../common/left.jsp" %>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<form id="frm" class="form-horizontal" role="form" action="/studentUpdate" method="get">
				
					<input type="hidden" name="id" value="${studentVo.id}">
				
				
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">프로필</label>
						<div class="col-sm-10">
							<img src="/pic?id=${studentVo.id}">
						</div>
					</div>
					
					
					<div class="form-group">
						<label for="id" class="col-sm-2 control-label">학생 ID</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.id}</label>
						</div>
					</div>

					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">학생 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.name}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="call_count" class="col-sm-2 control-label">호출 횟수</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.call_count}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="add1" class="col-sm-2 control-label">주소</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.add1}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="add2" class="col-sm-2 control-label">상세주소</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.add2}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="zipcd" class="col-sm-2 control-label">우편번호</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.zipcd}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="pic" class="col-sm-2 control-label">파일이름</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.pic}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="picpath" class="col-sm-2 control-label">파일경로</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.picpath}</label>
						</div>
					</div>
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">등록일시</label>
						<div class="col-sm-10">
							<label class="control-label">${studentVo.reg_dt}</label>
						</div>
					</div>
					

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">정보 수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
