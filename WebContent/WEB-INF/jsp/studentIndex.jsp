<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员主页</title>
</head>
<body>
	<h1>学员主页</h1>
	<h3>${requestScope.result}</h3>
	<a href="${pageContext.request.contextPath}/student/selectClass?studentId=${requestScope.s.studentId}">选课</a><br>
	<a href="${pageContext.request.contextPath}/student/checkScore?studentId=${requestScope.s.studentId}">查询成绩</a><br>
	<a href="${pageContext.request.contextPath}/student/lInfLossReport?studentId=${requestScope.s.studentId}">听课信息与听课证挂失</a><br>
	<a href="${pageContext.request.contextPath}/student/changeStudentInf?studentId=${requestScope.s.studentId}">修改个人信息</a><br>
	<a href="${pageContext.request.contextPath}/student/changeStudentPw?studentId=${requestScope.s.studentId}">修改密码</a><br>
	<a href="${pageContext.request.contextPath}/manager/showNews">退出登录</a><br>
</body>
</html>