<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Header:</h1>
<%=request.getHeader("host") %> </b>
<%--expression language kullanarak header implicit object almak: --%>
${header.host }
<h1>Request:</h1>
<%=request.getContextPath() %>
<%--expression language'de request objesine direk erişim yok.
bu erişimi söyle sağlayabiliriz: pageContext.request  (bir alt seviyeye inmiş oldum)
bean'ın propertysine erişim sağlıyorum
pageContext diğerleri gibi map değil bean'dir.
pageContext üzerinden ServletRequest objesini aldık.
Burada getter'ı kendisi otomatik çalıştırdı.--%>
<p> Expression language ile: ${pageContext.request.contextPath} </p>

<h1>Init param:</h1>
 <%--init param expression language implicit object, context parametrelerini tutan map'tir.
 web.xml'de tanımladım buradan erişim sağlıyorum. --%>
${initParam.myContextParam }

<%--Not: Expression Language genel olarak hata vermeme eğilimi gösterir.
İlgili attribute ismini yanlis yazsakta patlamıyor. Dikkat etmek gerek. 
${100%noattribute} mod işleminde patlıyor. --%>
<h1> Expression Language ile basit matematiksel islemler: </h1>
<%--noattribute diye bir şey yok. --%>
${10<noattribute}
${-10<noattribute }
${true and noattribute }
${10+2 }

</body>
</html>