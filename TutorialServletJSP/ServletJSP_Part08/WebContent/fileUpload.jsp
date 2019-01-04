<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>file upload jsp</title>
</head>
<body>

	<div>
		<h3>Yuklemek istediginiz dosya:</h3>
		<%-- enctype, ASCII olmayan verilerin gönderilmesi için kullanılır. (Dosya yükleme vb.) --%>
		<form action="file.upload" method="post" enctype="multipart/form-data">
			<input type="file" name="file" /> <input type="submit"
				value="upload" />

		</form>
	</div>
</body>
</html>