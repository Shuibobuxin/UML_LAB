<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训师信息修改页面</title>
</head>
<body>
	<h1>培训师信息修改页面</h1>
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="teacher" method="post" action="${pageContext.request.contextPath}/manager/changeTeacherInf.do">
		姓名:<form:input path="name"/><br>
		性别:<form:radiobutton path="sex" value="男"/>男&nbsp;
		<form:radiobutton path="sex" value="女"/>女&nbsp;<br>
		电话:<form:input path="phone"/><br>
		简介:<form:input path="teacherInf"/><br>
		<form:input type="hidden" path="teacherId" value="${requestScope.t.teacherId}"/><br>
		<input type="submit" value="修改"/>
		<a href="${pageContext.request.contextPath}/manager/listTeacher">返回</a><br>
	</form:form>
</body>
</html>