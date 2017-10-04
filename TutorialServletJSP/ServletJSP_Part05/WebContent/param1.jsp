<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>param1.jsp</title>
</head>
<body>

	<%--input alanlarimiza yazdigimiz degerleri 
HttpServletRequest objesi uzerinden getParameter() metodu ile ulasabiliyorduk.  --%>



	<jsp:useBean id="person1"
		class="_01jspaction.request.dispatch.model.Person">
		<jsp:setProperty name="person1" property="name"
			value='<%=request.getParameter("firstName")%>' />
		<jsp:setProperty name="person1" property="surname"
			value='<%=request.getParameter("lastName")%>' />
		<jsp:setProperty name="person1" property="age"
			value='<%=request.getParameter("age")%>' />
	</jsp:useBean>

	<%--<jsp:setProperty>‘de request.getParemeter() metodunu 
kullanmak yerine param alanini da kullanabiliriz. 
<jsp:setProperty name="person1" property="name" param="firstName" /> 
<jsp:setProperty name="person1" property="surname" param="lastName" />
<jsp:setProperty name="person1" property="age" param="age" />

param kısımları HTML dosyamızdaki text alanlarının isimleridir.
Expression <%= kullansak ve int değerimiz olsa parse işlemi yapmak zorundayız.
param, parse işlemlerini otomatik yapmaktadır.
--%>

	<%--
param yapisindan daha kisa bir yol olarak;
html dosyasındaki name kısımları person class'ımızın instance variable'ları ile aynı olursa:
name="name", name="surname", name="age"...
<jsp:setProperty name="person1" property="name" />
<jsp:setProperty name="person1" property="surname" />
<jsp:setProperty name="person1" property="age" />
request parametreleri bean’in  property isimleri/instance variable ile eslesirse 
<jsp:setProperty> de eslesme islemi otomatik olarak yapilacaktir.
 --%>
 
 <%--
 Daha kisa bir yol olarak: 
 form ve person sınıfının name ile instance variable isimleri eşleştiği sürece
 <jsp:setProperty> de  property alani icin * karakterini kullanabiliriz.
  		<jsp:setProperty name="person1" property="*" /> 
 
  --%>

	<jsp:getProperty property="name" name="person1" />
	<jsp:getProperty property="surname" name="person1" />
	<jsp:getProperty property="age" name="person1" />
</body>
</html>