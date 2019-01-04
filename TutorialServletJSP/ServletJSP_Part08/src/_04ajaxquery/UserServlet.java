package _04ajaxquery;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/user.servlet")
public class UserServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nameJava = req.getParameter("nameJava");
		PrintWriter writer=resp.getWriter();
		writer.print("Degisen isim: "+ nameJava);

	}
}
