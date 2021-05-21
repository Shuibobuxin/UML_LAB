<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>学员密码修改页面</title>
</head>
<body>
	<h1>学员密码修改页面</h1>
	<h3>${requestScope.result}</h3>
	<form action="${pageContext.request.contextPath}/student/changeStudentPw.do" method="post">
		输入修改后密码:<input type="text" name="password1" value="${param.password1}"/><br>
		请重新输入密码:<input type="text" name="password2" value="${param.password2}"/><br>
		<input type="hidden" name="studentId" value="${requestScope.s.studentId}"/>
		<input type="submit" value="修改"/>
		<a href="${pageContext.request.contextPath}/student/studentIndex?studentId=${requestScope.s.studentId}">返回</a><br>
	</form>
</body>
</html>