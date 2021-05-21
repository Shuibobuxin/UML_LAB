<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训师登录页面</title>
</head>
<body>
	<h1>培训师登录页面</h1>
	
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="teacher" method="post" action="${pageContext.request.contextPath}/teacher/login.do">
		账户:<form:input path="teacherId"/><br>
		密码:<form:password path="password"/><br>
		<input type="submit" value="登录"/>
	</form:form>
	<a href="${pageContext.request.contextPath}/manager/showNews">返回</a><br>
</body>
</html>