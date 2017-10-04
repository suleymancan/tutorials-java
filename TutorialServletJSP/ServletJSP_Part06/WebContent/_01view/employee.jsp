<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>

<%@ page import="_01model.Employee"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL</title>
</head>
<body>
	<%--datayı scriplet ve use bean ile almayı biliyorum.
usebean sadece bir derinliğe gidebiliyor yani
employee.department. yapamıyorum.
bu notta datayı expression language ile alacağım.
expression language grameri:
${first.second}
$ işaretli expression language jsp'de sadece getter islemiyle calisir.
jsf'de lifecycle'a göre getter veya setter çalistirir.
$ -> yazma islemi yapmaktadır.

${attributename. attribute tipinin sınıfının instance variable'ı veya bir aşağı derinliği}
expression language kullanarak objemizin instance variable'larına erişim sağlayacağım.
 --%>
	<h1>Expression Language Kullanimi: Ornek 1</h1>
	${employeeModel.id}
	</br> ${employeeModel.name}
	</br> ${employeeModel.surname}
	</br> ${employeeModel.department.id}
	</br> ${employeeModel.department.name}
	</br>

	<%--
 expression language grameri içerinde kullandığım .(nokta) ile map' e de erişim sağlayabilirim.
 gramer: ${map.key} şeklindedir.
  --%>
	<h1>Expression Language Kullanimi: Ornek 2</h1>
	<p>Memos maas: ${employeeSalaries.memosmaas}</p>
	<p>Nazli maas: ${employeeSalaries.nazlimaas}</p>

	<%-- . operatörü ile expression language'de beanlere ve maplere erişim sağlayabiliriz.
 ${bean.property} ${map.key} 
 key ve property adlarını yanlış yazarsak veya olmayan bir şeyi yazarsak hata alırız.
 bean adını (attributename) yanlış yazarsak hata almayız. o kısım çalışmaz --%>


</body>
</html>