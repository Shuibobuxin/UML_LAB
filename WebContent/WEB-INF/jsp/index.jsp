<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首页</title>
<style>
.div1{
	margin:0 auto;
	width: 1000px;
	height: 1300px;
}.div2{
	padding:50px;
	float:left;
	width: 195px;
	height: 1250px;
}.div3{
	padding:50px;
	padding-top:10px;
	float:left;
	width: 595px;
	height: 1250px;
}
</style>
</head>
<body>
<h1 align="center">系统首页</h1>
<div class="div1">
	<div class="div2">
		<a href="${pageContext.request.contextPath}/student/login">学员登录</a><br>
		<a href="${pageContext.request.contextPath}/teacher/login">培训师登录</a><br>
		<a href="${pageContext.request.contextPath}/manager/login">管理员登录</a><br>
	</div>
	<div class="div3">
		<h3 align="center">新闻</h3>
		<c:forEach items="${requestScope.newsps }" end="9" var="n">
			<h5 align="center"><a href="${pageContext.request.contextPath}/manager/showTheNews?newsId=${n.newsId}&publishTime=${n.publishTime}">${requestScope.NService.SelectNewsById(n.newsId).getTitle()}</a></h5>
		</c:forEach>
	</div>
</div>
</body>
</html>