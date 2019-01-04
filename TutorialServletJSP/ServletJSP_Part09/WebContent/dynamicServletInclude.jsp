<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>dynamicServletInclude</title>
</head>
<body>

	<%
		PrintWriter pw = response.getWriter();
	%>


	<%
		pw.println("#rd.include#");
		RequestDispatcher rd = request.getRequestDispatcher("/dynamicIncludeMe");
		rd.include(request, response);
	%>
	<br />
	<%
		pw.println("#pageContext.include#");
		pageContext.include("/dynamicIncludeMe");
	%>
	<p style="color: red;">#jsp include action#</p>
	<jsp:include page="/dynamicIncludeMe" />
	<%--servleti annotation ile tanımladıysak, burada gözükmez. web.xml'de tanımlamalıyız. --%>
	
	<p>
    page attributeunde expression kullanilabilir!</p>
	
	<%
		String pageURL = "includeMe.jsp";
	%>
	
	<jsp:include page="<%=pageURL%>" />

</body>
</html>