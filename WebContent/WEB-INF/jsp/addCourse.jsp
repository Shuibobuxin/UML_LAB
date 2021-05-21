<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>课程添加页面</title>
</head>
<body>
	<h1>课程添加页面</h1>
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="course" method="post" action="${pageContext.request.contextPath}/manager/addCourse.do">
		名称:<form:input path="courseName"/><br>
		简介:<form:input path="courseInf"/><br>
		<form:input  type="hidden" path="courseSign" value="1"/><br>
		<input type="submit" value="添加"/>
	<a href="${pageContext.request.contextPath}/manager/manageCourse">返回</a><br>
	</form:form>
</body>
</html>