<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>关闭选课页面</title>
</head>
<body>
<h1>关闭选课页面</h1>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>班级号</b></th>
		<th><b>课程名</b></th>
		<th><b>年</b></th>
		<th><b>季度</b></th>		
		<th><b>开设时间</b></th>
		<th><b>已选/限选</b></th>
		<th><b>关闭选课</b></th>
	</tr>
	<c:forEach items="${requestScope.classes }" var="c">
		<tr>
		<th><b>${c.classId}</b></th>
		<th><b>${requestScope.CService.SelectCourseById(c.courseId).getCourseName()}</b></th>
		<th><b>${c.year}</b></th>
		<th><b>${c.season}</b></th>
		<th><b>${c.time}</b></th>
		<th><b>${c.numberNow}/${c.numberMax}</b></th>
		<th><b><a href="${pageContext.request.contextPath}/manager/closeClass.do?classId=${c.classId}">关闭</a></b></th>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/manager/manageClass">返回</a><br>
</body>
</html>