<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程管理页面</title>
</head>
<body>
	<h1>课程管理页面</h1>
	<h3>${requestScope.result}</h3>
	<a href="${pageContext.request.contextPath}/manager/addCourse">添加课程</a><br>
	<a href="${pageContext.request.contextPath}/manager/listCourse">课程信息维护</a><br>
	<a href="${pageContext.request.contextPath}/manager/managerIndex">返回</a><br>
</body>
</html>