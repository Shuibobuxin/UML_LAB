<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>听课证补办</title>
</head>
<body>
	<h1>听课证补办</h1>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>姓名</b></th>
		<th><b>学号</b></th>
		<th><b>听课信息详细</b></th>
		<th><b>补办</b></th>
	</tr>
	<c:forEach items="${requestScope.students }" var="s">
		<tr>
		<th><b>${s.name}</b></th>
		<th><b>${s.studentId}</b></th>
		<th><b><a href="${pageContext.request.contextPath}/manager/StudentCSI?studentId=${s.studentId}">详细</a></b></th>
		<th><b><a href="${pageContext.request.contextPath}/manager/lInfMakeUp.do?studentId=${s.studentId}">补办</a></b></th>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/manager/managerIndex">返回</a><br>
</body>
</html>