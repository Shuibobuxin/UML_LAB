<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>添加培训班</title>
</head>
<body>
	<h1>培训班添加页面</h1>
	<h3>${requestScope.result}</h3>
		<form:form modelAttribute="class" method="post" action="${pageContext.request.contextPath}/manager/addClass.do">
		最大可选人数:<form:input path="numberMax" value="20"/><br>
		年份:<form:input path="year"  value="2020"/><br>
		季度:<br>
		<form:radiobutton path="season" value="春季"/>春季<br>
		<form:radiobutton path="season" value="夏季"/>夏季<br>
		<form:radiobutton path="season" value="秋季"  checked="true"/>秋季<br>
		课程:<br>
		<c:forEach items="${requestScope.courses }" var="c">
			<form:radiobutton path="courseId" value="${c.courseId}"/>${c.courseName}<br>
		</c:forEach>
		<form:input  type="hidden" path="courseId" value=""/><br>
		任课老师:<br>
		<c:forEach items="${requestScope.teachers }" var="t">
			<form:radiobutton path="teacherId" value="${t.teacherId}"/>${t.name}<br>
		</c:forEach>
		<form:input  type="hidden" path="numberNow" value="0"/><br>
		<form:input  type="hidden" path="endSign" value="0"/><br>
		<form:input  type="hidden" path="closeSign" value="0"/><br>
		<input type="submit" value="添加"/>
		<a href="${pageContext.request.contextPath}/manager/manageClass">返回</a><br>
	</form:form>
</body>
</html>