package _01controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _01model.Department;
import _01model.Employee;

@WebServlet("/bracketServlet")
public class BracketServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// data
		Employee employee = new Employee(27, "Kiymet", "Can");
		Department dept1 = new Department(1, "EvHanimi");
		employee.setDepartment(dept1);
		// attribute ornek1 bean
		req.setAttribute("employeeModel2", employee);

		// ornek2: array
		String[] myFamily = { "Haci", "Kiymet", "Memos", "Nazli" };
		req.setAttribute("array", myFamily);

		// ornek3: arraylist
		List<String> familyList = Arrays.asList(myFamily);
		req.setAttribute("list", familyList);
		// dispatch
		RequestDispatcher dispatcher = req.getRequestDispatcher("/_01view/bracket.jsp");
		dispatcher.forward(req, resp);
	}

}
