package dao;

import java.util.List;



import model.Department;
import model.Employee;
import model.EmployeeDetails;
import model.NickName;
import model.ParkingSpace;
import model.Phone;
import model.Project;

public interface EmployeeDAO {

	public void insertEmployee(Employee employee);

	public Employee getEmployeeById(int id);

	public List<Employee> getEmployees();

	public void deleteEmployee(int id);
	
	public void raiseSalary(int id, int raise);
	
	public void insertDepartment (Department department);
	
	public void insertParkingSpace(ParkingSpace parkingSpace);
	
	public void insertProject(Project project);
	
	public void updateProject(Employee employee, Project project);
	
	public void insertPhone(Phone phone);
	
	public void updatePhone (Employee employee, Phone phone);
	
	public void updateNickName (Employee employee, NickName nickName);
	
	public void updateEmail(Employee employee, String email);
	
	public List<String> getEmployeeNames();
	
	public String getEmployeeNameById(int id);
	
	public List<Object[]> getEmployeeNameAndSurname();
	
	public List<EmployeeDetails> getEmployeeConstructorExpression();
	
	public List<Integer> getEmployeeNamedQuery();
	
	public List<Object[]> joinEmployeeAndPhone();
	
	public List<Object[]> leftOuterJoin();
	
	public List<Employee> betweenQuery(int minMaas, int maxMaas);
	
	public List<Department> likeQuery(String like);
	
	public List<Employee> inQuery(String project1Name, String project2Name);
	
	public List<Employee> allQuery(int depId);
	
	public List<Object[]> kumelemeQuery();
	
	public List<Object[]> groupByQuery();
	
	public List<Object[]> havingQuery(int maas);
	
	public List<Employee> orderByQuery();
	

	
}
