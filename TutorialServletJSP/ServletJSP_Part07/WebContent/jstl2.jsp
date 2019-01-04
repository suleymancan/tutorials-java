<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jstl2</title>
</head>
<body>
	<c:set var="testNot" value="72" scope="request"></c:set>
	<!-- value kisminda bosluk kullanmamaya dikkat et. value=""
scope belirtmezsek varsayılan olarak pagescope'a ekler. -->
	<c:set var="name" value="suleyman"></c:set>

	<c:if test="${testNot > 50 }">
		<p>Dersi gectin.</p>
	</c:if>
	<c:if test="${name == 'suleyman' }">
		<p>hosgeldin suleyman.</p>
	</c:if>

	<h1>c:choose yapisi</h1>
	<c:set var="maas" scope="request" value="5000"></c:set>
	<c:choose>
		<c:when test="${maas<1500 }">
			<p>Düsük Maas</p>
		</c:when>
		<c:when test="${maas<4000 }">
			<p>Iyı maas</p>
		</c:when>
		<c:otherwise>
			<p>maasim :)</p>
		</c:otherwise>
	</c:choose>
</body>
</html>