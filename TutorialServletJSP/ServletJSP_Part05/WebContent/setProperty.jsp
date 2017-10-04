<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- jsp:useBean action'i ilgili id ye sahip request bean attribute olmadigi durumda 
	yeni bir obje olusturur. Bunu deneyeceğim.
	thereIsNoBean isminde bir request scope attribute yok. 
	Dolayisiyla <jsp:useBean> yeni bir Person objesi olusturacaktir.
	--%>

	<jsp:useBean id="thereIsNoBean"
		class="_01jspaction.request.dispatch.model.Person" scope="request">
	</jsp:useBean>

	<%-- jsp:setProperty action'i ile property alanlarina deger atamasinda bulunabiliriz.
	<jsp:setProperty> attribute’u ilgili property alanlarina karsilik gelen value alanlarini atayacaktir.
	Burada eger “thereIsNoBean” isimli bir attribute olsa , mevcut degerlerini override edip degistirecektir.
	
    <jsp:setProperty> action’inini <jsp:useBean> action’i icinde ya da disinda kullanabiliriz.
    <jsp:setProperty> eger <jsp:useBean> action’i icindeyse, ilgili request scope attribute objesi 
    bulunmadiginda yani yeni bir obje olusturuldugu durumda calisir.
    Boylelikle mevcut objenin degerlerini override etmez. 
    jsp:useBean icinde kullandigimiz zaman eger yeni obje olusturulacaksa jsp:setProperty calisacaktir!
	jsp:useBean disinda kullandigimiz zaman obje olusturulsun ya da olusturlmasin jsp:setProperty calisir.
	Bu durumda onceki property degerleri override edilir.
	Başka bir deyişle;
	Eğer mevcut bir attribute'in olduğu <jsp:useBean blokları arasında setProperty kullanırsak 
	setProperty çalışmayacaktır.  Dolayiyisla id'si verilen attribute mevcut property degerlerini koruyacaktir.
	
	--%>
	<jsp:setProperty property="name" name="thereIsNoBean"
		value="Mehmet Ali" />
	<jsp:setProperty property="surname" name="thereIsNoBean" value="Can" />
	<jsp:setProperty property="age" name="thereIsNoBean" value="18" />

	<%--jsp:setProperty ile atadigimiz bu degerlere ulasalim. --%>

	<jsp:getProperty property="name" name="thereIsNoBean" />
	<jsp:getProperty property="surname" name="thereIsNoBean" />
	<jsp:getProperty property="age" name="thereIsNoBean" />


</body>
</html>