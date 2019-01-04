<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--çeşitli scope'lara attribute eklemiştim fakat sadece request scope direk erişim sağladı. --%>
	<h1>${myAttr}</h1>

	<%--varsayılan olarak attribute page scope'ta bakılır. 
Orada yoksa  request orada da yoksa session  o da yoksa  application scope'a bakılır. --%>

	<%--expression language request, session, application ve  page scope 
expression scope'da map olduğundan key.value şeklinde erişim sağlayabilirim. --%>

	${requestScope.myAttr} ${sessionScope.myAttr }
	${applicationScope.myAttr }


</body>
</html>