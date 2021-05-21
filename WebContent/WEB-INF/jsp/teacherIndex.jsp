<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训师页面</title>
</head>
<body>
	<h1>培训师页面</h1>
	<h3>${requestScope.result}</h3>
	<a href="${pageContext.request.contextPath}/teacher/addScore?teacherId=${requestScope.t.teacherId}">录入成绩</a><br>
	<a href="${pageContext.request.contextPath}/teacher/checkScore?teacherId=${requestScope.t.teacherId}">查询学员成绩</a><br>
	<a href="${pageContext.request.contextPath}/teacher/changeTeacherPw?teacherId=${requestScope.t.teacherId}">修改登录密码</a><br>
	<a href="${pageContext.request.contextPath}/manager/showNews">退出登录</a><br>
</body>
</html>