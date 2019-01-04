<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Giris</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td>Username:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr> 
			<td>Password: </td>
			<td> <input type="text" name="password"/> </td>
			
			</tr>
			
			<tr>
			<td> 
			<img alt="captcha" src="simpleCaptcha.jpg">
			</td>
			<td> <input type="text" name="captchaCode"/> </td>
			 </tr>
			 
			 <tr>
			 
			 <td> <input type="submit" value="Login"/> </td>
			 </tr>
			 
			 <tr> 
			 <td>${errorMessage}</td>
			 </tr>
		<%--formu submit edince ilgili servlet'e düşecek. (LoginServlet) --%>
		</table>

	</form>
</body>
</html>