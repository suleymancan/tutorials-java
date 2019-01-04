package _04session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/urlRewrite")
public class UrlRewrite extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		HttpSession session = req.getSession();
		session.setAttribute("key", "object value");

		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		String nonEncodedurl = "getUrlRewrite";
		// encodeURL yaparak jsessionid bilgisini urlde taşıyorum.
		String encodeUrl = resp.encodeURL("getUrlRewrite"); // resp.encodeURL
		pw.print("Giris - <a href=\"" + nonEncodedurl + "\">Click me</a>.");
		pw.print("Giris Encoded- <a href=\"" + encodeUrl + "\">Click me</a>."); // diger servlette url ile alakali.
		pw.println("</body></html>");
	}
}
