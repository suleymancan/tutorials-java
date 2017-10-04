package _03servletcontext;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ContextServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ServletContext context=getServletContext();
		//PrintWriter pw=resp.getWriter();  //getOutputStream ile birlikte kullanırsan java.lang.IllegalStateException'u yersin.
		String contextDeneme=context.getInitParameter("denemeContext");
		
		//pw.print("Context'ten dönen: "+contextDeneme+"<br>");
		System.out.println("Context'ten dönen: "+contextDeneme);
		
	//	projede yer alan webcontent altinda yer alan dosyalara erismek için ServletContext objesini kullanabiliriz.
		String mailDosya=context.getRealPath("/mail.txt");
	//	pw.print("mail.txt'nin adresi: "+mailDosya+"<br>");
		System.out.println("Mail'in gerçek adresi: "+mailDosya);
		
		
		//mail dosyasını yazdırma:
		InputStream inputStream = context.getResourceAsStream("/mail.txt");
		int content;
		ServletOutputStream os = resp.getOutputStream();
		while ((content = inputStream.read()) != -1) {
			
			os.write(content);
		}
	}
}
	


