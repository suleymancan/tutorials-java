package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

@WebServlet("/employeeController")
public class EmployeeController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// silme işlemini burada yapacağım.

		int id = Integer.parseInt(req.getParameter("employeeId"));
		EmployeeDAO employeeDao = new EmployeeDAOImpl();
		employeeDao.removeEmployee(id);

		// aynı sayfa üzerinde göstereceğim için son halini reflesh edip göstermem
		// gerek.

		List<Employee> employeeList = employeeDao.getEmployees();

		// attribute ekliyorum.
		req.setAttribute("allEmployees", employeeList);

		// requestdispatch ile bunu jsp sayfasında göstereceğim.

		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);

		// bu işlemden sonra redirect.html yaparak başarıyla silindi diyebilirim.
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// yeni bir kayıt eklediğimizi düşünelim.
		// formdan dataları yazıp göndereceğim.
		// bunun için req.getParameter kullanacağım.
		String name = req.getParameter("name");
		String surname = req.getParameter("surname");
		String salary = req.getParameter("salary");
		// bu kısma validizasyon eklenebilir. ben basit olarak dışarıdan datayı aldım.

		// DAO katmanına ulaşım sağlayacağım.
		EmployeeDAO employeeDao = new EmployeeDAOImpl();
		employeeDao.insertEmployee(name, surname, salary);

		// aynı sayfa üzerinde göstereceğim için son halini reflesh edip göstermem
		// gerek.

		List<Employee> employeeList = employeeDao.getEmployees();

		// attribute ekliyorum.
		req.setAttribute("allEmployees", employeeList);

		// requestdispatch ile bunu jsp sayfasında göstereceğim.

		RequestDispatcher dispatcher = req.getRequestDispatcher("employee.jsp");
		dispatcher.forward(req, resp);

	}
}
