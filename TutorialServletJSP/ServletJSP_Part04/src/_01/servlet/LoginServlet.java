package _01.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name="loginServlet", urlPatterns="/Login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		System.out.println("LoginServlet###doPost");
		
		//bundan sonraki satırlar ikinci örnek için geçerli.
		//ilk örneği çalıştırıp görmek istiyorsan bundan sonrasını açıklama satırı yap.
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		PrintWriter pw=resp.getWriter();
		System.out.println("Kullanici adi: "+username+" ve sifre: "+password);
	}
}
