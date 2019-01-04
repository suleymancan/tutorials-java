<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jstl</title>
</head>
<body>
	<h1>c:out vs expression:</h1>
	<c:out value="<h1> html c:out</h1>"></c:out>
	<p>
		<%="<h1> html expression</h1>"%>
	</p>
	<!-- expressionda html kodları rander edildi. c:out'ta güvenli şekilde yazıldı. -->
	<h1>--------------</h1>
	<h1>jstl attribute:</h1>
	<c:set var="sessionAttribute" scope="session"
		value="jstl sessionAttribute"></c:set>
	<p>
		<c:out value="${sessionAttribute }"></c:out>
	</p>
	<!-- value kısmında expression language de kullanabiliriz. -->
	<!-- 
<c:remove var="sessionAttribute"/>
<p>silindikten sonra: <c:out value="${sessionAttribute }"></c:out></p>
 -->

</body>
</html>