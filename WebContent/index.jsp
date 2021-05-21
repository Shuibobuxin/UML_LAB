<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
</head>
<body>
<h1>系统首页</h1>
<a href="${pageContext.request.contextPath}/student/login">学员登录</a><br>
<a href="${pageContext.request.contextPath}/teacher/login">培训师登录</a><br>
<a href="${pageContext.request.contextPath}/manager/login">管理员登录</a><br>
<a href="${pageContext.request.contextPath}/manager/showNews">新闻</a><br>
</body>
</html>