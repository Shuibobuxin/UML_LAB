<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻信息修改页面</title>
</head>
<body>
	<h1>新闻信息修改页面</h1>
	<h3>${requestScope.result}</h3>
	<form:form modelAttribute="news" method="post" action="${pageContext.request.contextPath}/manager/changeNewsInf.do">
		新闻标题:<form:input path="title"/><br>
		新闻正文:<form:input path="text"/><br>
		<form:input type="hidden" path="publishSign" value="0"/>
		<form:input type="hidden" path="newsId" value="${requestScope.n.newsId}"/>
		<input type="submit" value="修改"/>
		<a href="${pageContext.request.contextPath}/manager/listNews">返回</a><br>
	</form:form>
</body>
</html>