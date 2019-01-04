<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jstl3</title>
</head>
<body>
	<c:forEach begin="1" end="3" var="number">
		<p>
			<c:out value="${number}"></c:out>
		</p>

	</c:forEach>

	<h1>array forEach:</h1>
	<%
		int[] numbers = { 27, 55, 44 };
		request.setAttribute("numberArray", numbers);
	%>
	<%--items kısmına array, list vs verilebilir.
varStatus ile index no yazılabilir --%>
	<c:forEach var="i" items="${numberArray}" varStatus="loopStatus">
		<%--burada el de kullanabiliriz --%>
${loopStatus.index}:${i}
</c:forEach>
	<%--list, map vs. de eklenebilir. --%>
	<h1>list:</h1>
	<%
		java.util.List<String> myList = new java.util.ArrayList<String>();
		myList.add("anne");
		myList.add("baba");
		myList.add("kardes");
		request.setAttribute("myList", myList);
	%>
	<c:forEach var="l" items="${myList}">
${l},
</c:forEach>
	<h1>map:</h1>
	<%
		java.util.Map<String, String> myMap = new java.util.HashMap<String, String>();
		myMap.put("key1", "value1");
		myMap.put("key2", "value2");
		myMap.put("key3", "value3");
		request.setAttribute("myMapAttribute", myMap);
	%>
	<%--key value ciftine entry denir. --%>
	<c:forEach var="entry" items="${myMapAttribute}">
${entry}
<%--entry.key ve entry.value şeklinde de yazdırılabilir. --%>
	</c:forEach>

	<h1>forTokens</h1>
	<%--virgule gore ayırma islemi --%>
	<c:forTokens items="key1,key2,key3" delims="," var="element">
		<p>
			<c:out value="${element }"></c:out>
		</p>
	</c:forTokens>

</body>
</html>