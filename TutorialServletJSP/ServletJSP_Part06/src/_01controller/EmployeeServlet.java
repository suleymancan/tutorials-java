package _01controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import _01model.Department;
import _01model.Employee;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	//datayı elle hazırladım. 
	Employee employee=new Employee(27,"Suleyman","Can");
	Department dep=new Department(23, "Software");
	employee.setDepartment(dep);
	
	//attribute request, örnek 1 bean
	req.setAttribute("employeeModel", employee);
	
	//map tanımlayıp expression language ile erişeceğim, örnek 2
	 Map<String, Integer> employeeSalaries=new HashMap<String,Integer>();
	 employeeSalaries.put("memosmaas", 5000);
	 employeeSalaries.put("nazlimaas", 7000);
	 req.setAttribute("employeeSalaries", employeeSalaries);
	
	//dispatch işlemi
	RequestDispatcher dispatcher=req.getRequestDispatcher("/_01view/employee.jsp");
	dispatcher.forward(req, resp);
	
	
	}
}
