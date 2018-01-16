package dao;

import java.util.List;

import model.Employee;

//dao kısmı veritabanı içindir.

public interface EmployeeDAO {

	public void insertEmployee(String name, String surname, String salary);
	public List<Employee> getEmployees();
	
	public void removeEmployee(int id);
	
}
