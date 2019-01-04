<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="utf-8"%>

<%@ taglib uri="classicTagURI" prefix="cs"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>classic tag</title>
</head>
<body>

	<h4>classicTagHandler:</h4>
	<cs:myClassicTag />

	<h4>classicTagHandler2:</h4>
	<cs:myClassicTag2 />

	<h4>classicTagHandler3:</h4>
	<cs:myClassicTag3>
		<br />
bu kisim calisti.(body jsp)<br />
	</cs:myClassicTag3>

</body>
</html>