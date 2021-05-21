<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员选课页面</title>
</head>
<body>
	<h1>学员选课页面</h1>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>课程名</b></th>
		<th><b>课程简介</b></th>
		<th><b>任课老师</b></th>
		<th><b>已选/限选</b></th>
		<th><b>年度</b></th>
		<th><b>季度</b></th>
		<th><b>开设时间</b></th>
		<th><b>报名</b></th>
	</tr>
	<c:forEach items="${requestScope.NCloseClasses }" var="c">
		<tr>
		<th><b>${requestScope.CService.SelectCourseById(c.courseId).getCourseName()}</b></th>
		<th><b>${requestScope.CService.SelectCourseById(c.courseId).getCourseInf()}</b></th>
		<th><b>${requestScope.TService.selectTeacherById(c.teacherId).getName()}</b></th>
		<th><b>${c.numberNow}/${c.numberMax}</b></th>
		<th><b>${c.year}年</b></th>
		<th><b>${c.season}</b></th>
		<th><b>${c.time}</b></th>
		<c:if test="${c.numberNow<c.numberMax}">
			<th><b><a href="${pageContext.request.contextPath}/student/selectClass.do?classId=${c.classId}&studentId=${requestScope.s.studentId}">选课</a></b></th>
		</c:if>
		<c:if test="${c.numberNow==c.numberMax}">
			<th><b>不可选</b></th>
		</c:if>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/student/studentIndex?studentId=${requestScope.s.studentId}">返回</a><br>
</body>
</html>