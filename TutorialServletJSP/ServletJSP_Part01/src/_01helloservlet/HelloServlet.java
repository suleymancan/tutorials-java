package _01helloservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
1- HttpServlet'i extends ettim. 
2- doGet metodunu override ettim ve içindeki super'i sildim.
extends ve override ederken ctrl+space'ye basmak çok hoş. Canını yediğimin ide'si benim yerime tamamlıyor.
3- doGet içine bir tane sysout log ve bir tanede ekrana yazı bastım.
4-**tanıtımı xml veya annotation ile yapabiliriz. İkisinden birini yapmamız yeterli.

-----------------------------------------------------
web xml tanımlaması:
1-WebContent->WEB-INF->web.xml'i açtım.
2-<welcome-file-list> kısmını sildim.
3-<web-app> içine <servlet> tagı koydum onun içine de <servlet-name> ve <servlet-class> taglarını doldurdum.
<servlet-name> kısmına mantıklı bir isim verdim. 
<servlet-class> kısmı "package.classismi" şeklinde olacak. Sonuna .java yazmıycam. ctrl'ye basınca ilgili class'a gidebilmem gerek.
böylece şu class servlet class'ıdır demiş oldum. Şimdi hangi linke/adrese gittiğimizde bu servlet tetiklenecek? Mapping yapalım.
4-<web-app> içine <servlet-mapping> tagini da koydum onun içine de <servlet-name> ve <url-pattern> taglarını koydum.
<servlet-name> kısmı <servlet> içindeki name ile aynı olmalı. <url-pattern> de / ile başlamalı. Birden fazla url-pattern verebiliriz.
Herşey yolundaysa ilgili proje'yi run-as yapıp verdiğimiz name'e gittiğimizde örneğimin çalışması gerekiyor.
-----------------------------------------------------------
annotation tanımlaması:
class'ımızın üzerine @WebServlet("/ilkornek2") ile url'i verebiliyoruz. 
birden fazla url için: @WebServlet(urlPatterns={"ilkornek2","ilkornek3"}) yazarız.
*/
//xml ile tanımı yaptığım için burda bir daha url vermek biraz mantıksız oldu. O yüzden yorum satırına aldım. 
//İkisinden birini yapmamız yeterli.

@WebServlet("/ilkornek2")
public class HelloServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		// log
		System.out.println("İlk Servlet'imi çağırdım.");
		// ekrana
		Date date = new Date();
		String today = date.toString();
		PrintWriter pw = resp.getWriter();
		// Java kodunun içine html yazabiliyorum. <h4> tagini görmeseydi <html> <body>
		// eklemem gerekti.
		pw.println("<h4> Hello Servlet! Ben Süleyman Can.</h4>");
		pw.println("Today: " + today);

	}
}
