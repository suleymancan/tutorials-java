package _02servletconfig;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//web.xml yaklaşımı

public class ConfigServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		ServletConfig kofik = getServletConfig();
		
		// name verip value alırız.
		String kullanici = kofik.getInitParameter("kullanici");
		String sifre = kofik.getInitParameter("sifre");
		resp.getWriter().println("kullanici adi: " + kullanici + "<br>  sifre: " + sifre + "<br>");

		// tek servlet name döner.
		String servletName = kofik.getServletName();
		resp.getWriter().println("Servlet'e verdigim ad: " + servletName + "<br>");

		// tüm servlet nameleri döner.
		Enumeration<String> names = kofik.getInitParameterNames();
		int sayac = 1;
		while (names.hasMoreElements()) {
			resp.getWriter().println(sayac + ". " + "init param adi: " + names.nextElement() + "<br>");
			sayac++;
		}
		// config objesi üzerindem Context'e erişebiliyoruz.
		ServletContext context = kofik.getServletContext();


	}
}
