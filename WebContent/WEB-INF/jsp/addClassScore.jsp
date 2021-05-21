<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>录入成绩页面</title>
</head>
<body>
	<h1>录入成绩页面</h1>
	<h3>${requestScope.result}</h3>
	<form action="${pageContext.request.contextPath}/teacher/addClassScore" method="post">
		<c:forEach items="${requestScope.csis }" var="csi">
			${requestScope.SService.selectStudentById(csi.studentId).getName()}:<input type="text" name="${csi.studentId}"/><br>
		</c:forEach>
		<input type="hidden" name="teacherId" value="${requestScope.t.teacherId }"/>
		<input type="hidden" name="classId" value="${requestScope.c.classId }"/>
		<input type="submit" value="提交"/>
	</form>	
	<a href="${pageContext.request.contextPath}/teacher/addScore?classId=${c.classId}&teacherId=${requestScope.t.teacherId}">返回</a><br>
</body>
</html>