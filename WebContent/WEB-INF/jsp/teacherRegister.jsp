<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训师注册页面</title>
</head>
<body>
	<h1>培训师注册页面</h1>
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="teacher" method="post" action="${pageContext.request.contextPath}/manager/register.do">
		账户:<form:input path="teacherId"/><br>
		密码:<form:password path="password"/><br>
		姓名:<form:input path="name"/><br>
		性别:<form:radiobutton path="sex" value="男" checked="true"/>男&nbsp;
		<form:radiobutton path="sex" value="女"/>女&nbsp;<br>
		电话:<form:input path="phone"/><br>
		简介:<form:input path="teacherInf"/><br>
		<input type="submit" value="注册"/>
		<a href="${pageContext.request.contextPath}/manager/manageTeacher">返回</a><br>
	</form:form>
</body>
</html>