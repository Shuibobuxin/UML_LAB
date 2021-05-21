<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>培训师密码修改页面</title>
</head>
<body>
	<h1>培训师密码修改页面</h1>
	<h3>${requestScope.result}</h3>
	<form action="${pageContext.request.contextPath}/teacher/changeTeacherPw.do" method="post">
		输入修改后密码:<input type="text" name="password1" value="${param.password1}"/><br>
		请重新输入密码:<input type="text" name="password2" value="${param.password2}"/><br>
		<input type="hidden" name="teacherId" value="${requestScope.t.teacherId}"/>
		<input type="submit" value="修改"/>
		<a href="${pageContext.request.contextPath}/teacher/teacherIndex?teacherId=${requestScope.t.teacherId}">返回</a><br>
	</form>
</body>
</html>