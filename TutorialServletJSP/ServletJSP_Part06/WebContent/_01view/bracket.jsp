<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EL BRACKET</title>
</head>
<body>
	<%-- köşeli parantez ile bean, map, array, arraylist'e erişim sağlayabiliriz.
array ve arraylistler için nokta operatörünü kullanamiyoruz.
[] operatoru noktaya göre daha da kullanışlıdır.
köseli parantez içinde tek tırnak veya çift tırnak kullanmak farketmez. aynı şey --%>
	<h1>Bracket örnegi:</h1>
	${employeeModel2["id"]}
	</br> ${employeeModel2['name']}
	</br> ${employeeModel2["surname"]}
	</br> ${employeeModel2["department"]["id"]}
	</br> ${employeeModel2["department"]["name"]}

	<%--bean ve map için tırnak zorunludur. tırnagi yazmazsak yine calisir ama o alan gosterilmez.--%>

	<h1>Array ornegi:</h1>
	<%--parantez içinde tırnaga gerek yok.
grammer: arrayName[arraynumberno] --%>
	<p>Baba adi: ${array[0] }</p>
	<p>Anne adi: ${array['1'] }</p>
	<p>Brother: ${array["2"] }</p>
	<p>Sister: ${array[3] }</p>

	<h1>List ornegi:</h1>
	${list[0]} ${list[1]} ${list[2]} ${list[3]}
</body>
</html>