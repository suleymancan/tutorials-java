<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Static Inclusion</title>
</head>
<body>
	<h3 style="color: red;">header.html dosyasini ekleniyor:</h3>
	<%@include file="header.html"%>
	<h3 style="color: red;">includeMe.jsp dosyasini ekleniyor:</h3>
	<%@include file="includeMe.jsp"%>
	<h3 style="color: red;">footer.txt dosyasini ekleniyor:</h3>
	<%@include file="footer"%>

	<%--header.html, includeMe.jsp ve footer.txt dosyalarini include.jsp icerisine aktardim. --%>

	<%--file attributende expression kullanılamaz.
<% String myURL ="copyright.html"; %>
<%@ include file="<%= myURL %>" %>
hatalı bir kullanımdır.

file attribute’u included edilen sayfaya parametre gecemez.
<%@ include file="other.jsp?name=Suleyman" %>
 --%>
</body>
</html>