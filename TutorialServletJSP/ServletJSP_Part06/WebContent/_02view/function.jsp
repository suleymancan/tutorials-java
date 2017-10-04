<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
    
    <%@ taglib prefix="myPrefix" uri="myURI" %>
    <%--uri attribute tld dosyasındaki karşılıktır. --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%--myPrefix yardımıyla çağıracağım. --%>
${myPrefix:myFunction(10,17) }

<%--bu kadar uzun kullanma amacım jsp'de java kodu yazmamak. --%>
</body>
</html>