<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学生信息修改页面</title>
</head>
<body>
	<h1>学生信息修改页面</h1>
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="student" method="post" action="${pageContext.request.contextPath}/student/changeStudentInf.do">
		姓名:<form:input path="name"/><br>
		性别:<form:radiobutton path="sex" value="男"/>男&nbsp;
		<form:radiobutton path="sex" value="女"/>女&nbsp;<br>
		电话:<form:input path="phone"/><br>
		<form:input type="hidden" path="studentId" value="${requestScope.s.studentId}"/>
		<form:input type="hidden" path="lSign" value="${requestScope.s.lSign}"/>
		<form:input type="hidden" path="password" value="${requestScope.s.password}"/>
		<input type="submit" value="修改"/>
		<a href="${pageContext.request.contextPath}/student/studentIndex?studentId=${requestScope.s.studentId}">返回</a><br>
	</form:form>
</body>
</html>