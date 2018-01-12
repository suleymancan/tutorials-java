package model;

public class EmployeeDetails {

	private String name;
	private String surname;
	private String departmentName;
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
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public EmployeeDetails(String name, String surname, String departmentName) {
		super();
		this.name = name;
		this.surname = surname;
		this.departmentName = departmentName;
	}
	@Override
	public String toString() {
		return "EmployeeDetails [name=" + name + ", surname=" + surname + ", departmentName=" + departmentName + "]";
	}
	
	
	
	
}
