package _04session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/helloSession")
public class HelloSession extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		HttpSession session = req.getSession(); // session objesini aldım.
		if (session.isNew()) {
			System.out.println("new session");
			pw.print("New Session");
		} else {
			System.out.println("old session");
			pw.print("Old Session");
		}

	}
}
