<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>班级成绩页面</title>
</head>
<body>
	<h1>班级成绩页面</h1>
	<h2>${requestScope.courseName}</h2>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>学号</b></th>
		<th>姓名<b></b></th>
		<th><b>成绩</b></th>
	</tr>
	<c:forEach items="${requestScope.csis }" var="csi">
		<tr>
		<th><b>${csi.studentId}</b></th>
		<th><b>${requestScope.SService.selectStudentById(csi.studentId).getName()}</b></th>
		<th><b>${csi.score}</b></th>	
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/teacher/checkScore?teacherId=${requestScope.t.teacherId}">返回</a><br>
</body>
</html>