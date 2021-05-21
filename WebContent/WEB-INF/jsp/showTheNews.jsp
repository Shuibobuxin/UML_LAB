<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
.div1{
	padding-top:20px;
	margin:0 auto;
	width: 400px;
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
<title>新闻信息页面</title>
</head>
<body>
	<div class="div1">
		<h2 align="center">${requestScope.news.title}</h2>
		<p>${requestScope.news.text}</p>
		${requestScope.publishTime}<br>
		<a href="${pageContext.request.contextPath}/manager/showNews">返回</a><br>
	</div>
</body>
</html>