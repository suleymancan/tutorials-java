package dao;

import java.util.List;

import javax.persistence.Tuple;

import model.Employee;
import model.EmployeeDetails;

public interface EmployeeDAOCriteria {

	public List<Employee> findAllEmployeesWithCriteria();
	public List<String> getAllEmployeesNameWithCriteria();
	public List<Tuple> getEmployeeInformationWithCriteria();
	public String getDepartmentWithCriteria(String employee);
	public List<EmployeeDetails> getEmployeeDetails();
	public String getDepartmentOfEmployeeCriteriaJoin(String Employee);
	public List<Tuple> getEmployeeNameSalaryGreaterThan(int salary);
	public List<Tuple> getEmployeeNameSalaryBetween(int salary, int salary2);
	public List<Tuple> getEmployeeNameSalaryLike(String like);
	public List<Tuple> getEmployeeNameSalaryIn(List<Integer> salaries);
	public List<String> getDepartmentOfEmployeeIsNull();
}
