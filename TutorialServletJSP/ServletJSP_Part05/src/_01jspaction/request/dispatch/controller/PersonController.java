package _01jspaction.request.dispatch.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _01jspaction.request.dispatch.model.Person;

@WebServlet("/person")
public class PersonController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Person person1 = new Person("Suleyman", "Can", "22");
		req.setAttribute("personim", person1);
		// setProperty örneğini çalıştırmak için yönlendirmeye setProperty.jsp yazmak
		// yeterli.
		RequestDispatcher dispatcher = req.getRequestDispatcher("useBean.jsp");
		dispatcher.forward(req, resp);
	}

}
