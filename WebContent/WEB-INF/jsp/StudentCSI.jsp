<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>听课信息页面</title>
</head>
<body>
	<h1>听课信息页面</h1>
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
	<a href="${pageContext.request.contextPath}/manager/lInfMakeUp">返回</a><br>
</body>
</html>