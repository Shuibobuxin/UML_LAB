<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训师列表</title>
</head>
<body>
	<h1>培训师列表页面</h1>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>姓名</b></th>
		<th><b>ID</b></th>
		<th><b>修改信息</b></th>
	</tr>
	<c:forEach items="${requestScope.teachers }" var="t">
		<tr>
		<th><b>${t.name}</b></th>
		<th><b>${t.teacherId}</b></th>
		<th><b><a href="${pageContext.request.contextPath}/manager/changeTeacherInf?teacherId=${t.teacherId}">修改信息</a></b></th>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/manager/manageTeacher">返回</a><br>
</body>
</html>