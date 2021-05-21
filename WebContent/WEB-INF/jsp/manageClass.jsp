<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训班管理页面</title>
</head>
<body>
	<h1>培训班管理页面</h1>
	<h3>${requestScope.result}</h3>
	<a href="${pageContext.request.contextPath}/manager/addClass">开设培训班</a><br>
	<a href="${pageContext.request.contextPath}/manager/closeClass">培训班关闭选课</a><br>
	<a href="${pageContext.request.contextPath}/manager/managerIndex">返回</a><br>
</body>
</html>