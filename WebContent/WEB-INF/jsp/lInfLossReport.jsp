<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>听课信息与听课证挂失页面</title>
</head>
<body>
<h1>听课信息与听课证挂失页面</h1>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>课程名</b></th>
		<th>班级号<b></b></th>
	</tr>
	<c:forEach items="${requestScope.csis }" var="csi">
		<tr>
		<th><b>${csi.courseName}</b></th>
		<th><b>${csi.classId}</b></th>
		</tr>
	</c:forEach>
	</table>
	<c:if test="${requestScope.s.lSign==1}">
		<a href="${pageContext.request.contextPath}/student/lInfLossReport.do?studentId=${requestScope.s.studentId}">取消挂失</a><br>
	</c:if>
	<c:if test="${requestScope.s.lSign==0}">
		<a href="${pageContext.request.contextPath}/student/lInfLossReport.do?studentId=${requestScope.s.studentId}">挂失听课证</a><br>
	</c:if>
	<a href="${pageContext.request.contextPath}/student/studentIndex?studentId=${requestScope.s.studentId}">返回</a><br>
</body>
</html>