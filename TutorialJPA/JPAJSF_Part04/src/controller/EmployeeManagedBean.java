package controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;

@ManagedBean(name = "employeeManagedBean")
@SessionScoped
public class EmployeeManagedBean {

	private String name;
	private String surname;
	private int salary;
	private List<Employee> employees;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public void addEmployee() {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		Employee employee = new Employee(name, surname, salary);
		employeeDAO.insertEmployee(employee);
		employees = employeeDAO.findAllEmployees();

	}

	public void deleteEmployee(int id) {
		EmployeeDAO employeeDAO = new EmployeeDAOImpl();
		employeeDAO.removeEmployee(id);
		employees = employeeDAO.findAllEmployees();
	}
}
