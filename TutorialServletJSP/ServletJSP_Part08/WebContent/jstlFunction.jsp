<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>

<%--ilgili taglib'i ekliyorum. --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>jstl functions</title>
</head>
<body>
	${fn:toUpperCase("süleyman can")}

	<c:set var="sessionAttribute" scope="session" value="my session value"></c:set>
	<%--my içeriyor mu? --%>
	<br>${fn:contains(sessionAttribute,"my")}
	<br />

	<%--string array arasına ; koyma. --%>

	<%
		String[] myArray = { "test1", "test2", "test3" };
		request.setAttribute("myArray", myArray);
	%>
	${fn:join(myArray,';') }
</body>
</html>