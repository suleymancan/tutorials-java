package _02expressionImplicit;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/implicit")
public class ImplicitServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("myAttr", "request value");
		req.getSession().setAttribute("myAttr", "session value");
		getServletContext().setAttribute("myAttr", "application value");

		RequestDispatcher dispatcher = req.getRequestDispatcher("_02view/implicit.jsp");
		dispatcher.forward(req, resp);
	}
}
