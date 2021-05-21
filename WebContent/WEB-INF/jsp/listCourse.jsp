<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程列表页面</title>
</head>
<body>
	<h1>课程列表页面</h1>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>课程名</b></th>
		<th><b>简介</b></th>
		<th><b>是否可开设</b></th>
		<th><b>修改课程</b></th>
		<th><b>开设权限</b></th>
		<th><b>删除课程</b></th>
	</tr>
	<c:forEach items="${requestScope.courses }" var="c">
		<tr>
		<th><b>${c.courseName}</b></th>
		<th><b>${c.courseInf}</b></th>
		<c:if test="${c.courseSign==0}">
			<th><b>不可开设</b></th>
		</c:if>
		<c:if test="${c.courseSign==1}">
			<th><b>可开设</b></th>
		</c:if>
		<th><b><a href="${pageContext.request.contextPath}/manager/changeCourseInf?courseId=${c.courseId}">修改信息</a></b></th>
		<c:if test="${c.courseSign==0}">
			<th><b><a href="${pageContext.request.contextPath}/manager/changeCourseSign?courseId=${c.courseId}">设为可开设</a></b></th>
		</c:if>
		<c:if test="${c.courseSign==1}">
			<th><b><a href="${pageContext.request.contextPath}/manager/changeCourseSign?courseId=${c.courseId}">设为不可开设</a></b></th>
		</c:if>
		<th><b><a href="${pageContext.request.contextPath}/manager/deleteCourse?courseId=${c.courseId}">删除</a></b></th>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/manager/manageCourse">返回</a><br>
</body>
</html>