<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--  
	jsp:useBean action'u:
    id alanindaki “personim", PersonController servlet sinifimizda request scope'a 
    ekledigim Person objesinin attribute ismi. Ayni id ismini birden fazla kullanamayiz.
    class alanina Person sinifimi yazdim.  packagename.classname
    jsp:useBean icin varsayilan scope “page” scope/yasam alanidir. 
    Servlet sinifimizda request scope’una attribute eklendigi icin burada da scope olarak request belirttim.
    
--%>

	<%--
Person class'ı abstract bir class olsaydı;
abstract bir sinifi burada <jsp:useBean class alaninda kullanamayiz! 
Bu jsp dosyamiz bize derleme hatasi verecektir.
<jsp:useBean> ‘de class alaninda sinif bilgisini yaziyoruz. 
Bu durumda class alani hem obje hem referans tipini belirlemis oluyor. 

Bu durumda yeni bir alan kullanabiliriz; type
type alani class alani olmadan kullanilabilir, 
fakat bu durumda ilgili attribute objesi ilgili scope’ta olmak zorundadir. 
Aksi durumda java.lang.InstantiationException firlatilacaktir.
<jsp:useBean id="thereIsNoBean" type="_01jspaction.request.dispatch.model.AbstractPerson" scope="request">
class ve type beraber kullanilabilir. 
type alani tek basina kullanilabilir. Sinif abstract olmasa bile yeni bir obje olusmaz.
 --%>

	<jsp:useBean id="personim"
		class="_01jspaction.request.dispatch.model.Person" scope="request" />
	<p>
		<jsp:getProperty property="name" name="personim" />
	</p>
	<p>
		<jsp:getProperty property="surname" name="personim" />
	</p>
	<p>
		<jsp:getProperty property="age" name="personim" />
	</p>

	<%-- 
	jsp:getProperty action'u:
	property alanina ulasmak istedigimiz instance variable’imizin ismini yaziyoruz.
	property alanlarina ulasabilmek icin getter metodu olmalidir.
	Person sinifinda name, surname, age property’lerimiz vardi.
	name alanina ise <jsp:useBean> de kullanmis oldugumuz id degerini yazmamiz gereklidir. 
	--%>
	<%-- 
<jsp:useBean> yeni bir bean olusturabilir. 
Eger <jsp:useBean> “personim” isminde tanimlanan attribute objesini bulmasaydı
yeni bir Person objesi olustururdu. Ilgili attribute varsa eslestirilir yoksa (null)
 yeni bir Person objesi olusturulur ve “personim” ismiyle request scope’a attribute olarak ekler.
 --%>
</body>
</html>