<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
    <%--prefix degerini kafamdan belirledim. --%>
    <%@ taglib uri="simpleTagURI" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>simple tag</title>
</head>
<body>
<s:mySimpleTag/>
<%--bu kısım tld dosyasına, tld dosyasıda ilgili class'a giderek ekrana veriyi basıyor. --%>

<s:mySimpleTag2>
 <p>SimpleTaHandler body, it works!</p>
 <%--doTag'de body invoke edilip, bu kısım çalışacak. --%>
</s:mySimpleTag2>

<h1>SimpleTagHandler3</h1>
<s:mySimpleTag3 userName="admin">

</s:mySimpleTag3>
</body>
</html>