<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训师管理页面</title>
</head>
<body>
	<h1>培训师管理页面</h1>
	<h3>${requestScope.result}</h3>
	<a href="${pageContext.request.contextPath}/manager/register">培训师账户注册</a><br>
	<a href="${pageContext.request.contextPath}/manager/listTeacher">培训师信息修改</a><br>
	<a href="${pageContext.request.contextPath}/manager/managerIndex">返回</a><br>
</body>
</html>