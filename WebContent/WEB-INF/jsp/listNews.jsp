<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新闻列表页面</title>
</head>
<body>
	<h1>新闻列表页面</h1>
	<h3>${requestScope.result}</h3>
	<table border="1" cellspacing="0" cellpadding="5">
	<tr>
		<th><b>新闻标题</b></th>
		<th>新闻修改<b></b></th>
		<th><b>新闻发布</b></th>
	</tr>
	<c:forEach items="${requestScope.newsL }" var="n">
		<tr>
		<th><b>${n.title}</b></th>
		<c:if test="${n.publishSign==0}">
			<th><b><a href="${pageContext.request.contextPath}/manager/changeNewsInf?newsId=${n.newsId}">修改</a></b></th>
		</c:if>
		<c:if test="${n.publishSign==1}">
			<th><b>请先下架</b></th>
		</c:if>
		<c:if test="${n.publishSign==0}">
			<th><b><a href="${pageContext.request.contextPath}/manager/changeNewsPublish?newsId=${n.newsId}">发布</a></b></th>
		</c:if>
		<c:if test="${n.publishSign==1}">
			<th><b><a href="${pageContext.request.contextPath}/manager/changeNewsPublish?newsId=${n.newsId}">下架</a></b></th>
		</c:if>
		</tr>
	</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath}/manager/manageNews">返回</a><br>
</body>
</html>