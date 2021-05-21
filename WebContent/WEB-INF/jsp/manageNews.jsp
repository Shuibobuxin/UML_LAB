<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻管理页面</title>
</head>
<body>
	<h1>新闻管理页面</h1>
	<h3>${requestScope.result}</h3>
	<a href="${pageContext.request.contextPath}/manager/addNews">添加新闻</a><br>
	<a href="${pageContext.request.contextPath}/manager/listNews">课程信息维护</a><br>
	<a href="${pageContext.request.contextPath}/manager/managerIndex">返回</a><br>
</body>
</html>