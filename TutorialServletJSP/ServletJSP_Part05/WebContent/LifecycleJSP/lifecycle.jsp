<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%!public void jspInit() {

		ServletConfig config = getServletConfig();
		String sehir = config.getInitParameter("sehir");
		String takim = config.getInitParameter("takim");
		System.out.println("Benim şehrim: " + sehir);
		System.out.println("Benim takimim: " + takim);
	}

	public void jspDestroy() {

		System.out.println("Destroy oluyor!");

	}%>

</body>
</html>