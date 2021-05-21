<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员注册页面</title>
</head>
<body>
	<h1>学员注册页面</h1>
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="student" method="post" action="${pageContext.request.contextPath}/student/register.do">
		账户:<form:input path="studentId"/><br>
		密码:<form:password path="password"/><br>
		姓名:<form:input path="name"/><br>
		性别:<form:radiobutton path="sex" value="男" checked="true"/>男&nbsp;
		<form:radiobutton path="sex" value="女"/>女&nbsp;<br>
		电话:<form:input path="phone"/><br>
		<form:input  type="hidden" path="lSign" value="0"/><br>
		<input type="submit" value="注册"/>
		<a href="${pageContext.request.contextPath}/manager/showNews">返回</a><br>
	</form:form>
	
</body>
</html>