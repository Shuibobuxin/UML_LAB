<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程信息修改页面</title>
</head>
<body>
	<h1>课程信息修改页面</h1>
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="course" method="post" action="${pageContext.request.contextPath}/manager/changeCourseInf.do">
		课程名称:<form:input path="courseName"/><br>
		课程简介:<form:input path="courseInf"/><br>
		<form:input type="hidden" path="courseSign" value="${requestScope.c.courseSign}"/><br>
		<form:input type="hidden" path="courseId" value="${requestScope.c.courseId}"/><br>
		<input type="submit" value="修改"/>
		<a href="${pageContext.request.contextPath}/manager/listCourse">返回</a><br>
	</form:form>
</body>
</html>