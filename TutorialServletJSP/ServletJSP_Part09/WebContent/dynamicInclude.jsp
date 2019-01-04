<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Dynamic Include</title>
</head>
<body>
	<%--dynamic inclusion icin aşağıdaki üç yontemi de kullanabiliriz: --%>
	<%--request JSP implicit objesini kullanarak RequestDispatcher objesi elde edebiliriz.
	    include metodunu kullanarak dynamic inclusion islemini yapabiliriz --%>
	<%PrintWriter pw = response.getWriter(); %>

	<%
	
		pw.println("#rd.include#");
		RequestDispatcher rd = request.getRequestDispatcher("includeMe.jsp");
		rd.include(request, response);
	%>

	<%
		pw.println("#pageContext.include#");
		pageContext.include("includeMe.jsp");
	%>
	<p>#jsp include action#</p>
	<jsp:include page="includeMe.jsp"></jsp:include>
	
	

</body>
</html>