<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员页面</title>
</head>
<body>
	<h1>管理员页面</h1>
	<h3>${requestScope.result}</h3>
	<a href="${pageContext.request.contextPath}/manager/manageTeacher">培训师管理</a><br>
	<a href="${pageContext.request.contextPath}/manager/manageCourse">课程管理</a><br>
	<a href="${pageContext.request.contextPath}/manager/manageClass">培训班管理</a><br>
	<a href="${pageContext.request.contextPath}/manager/manageNews">新闻管理</a><br>
	<a href="${pageContext.request.contextPath}/manager/lInfMakeUp">听课证补办</a><br>
	<a href="${pageContext.request.contextPath}/manager/showNews">退出登录</a><br>
</body>
</html>