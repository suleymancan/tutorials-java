<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%--directives kullanarak oluşturduğum tag dosyasına erişeceğim. --%>

<%@ taglib prefix="myTag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>file tag</title>
</head>
<body>

	<%--kullanımı: --%>
	<myTag:header>
		<%--bu araya yazılanlar çalısmaz. --%>
	</myTag:header>

	<myTag:header2 tittle="my title value "></myTag:header2>
	<%--header2'yi yüklerken burada verdiğim tittle değerini tag dosyasının ${title } kısmına yazmış olacak. --%>

	<myTag:header3>
bu kısım doBody tagi sayesinde çalışıyor.
</myTag:header3>
</body>
</html>