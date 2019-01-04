package model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//entity class ozellikllerini sagladı. (5 ozellik vardı)
// entity ve id anotationu minimum gerekli olan anatationlardır.
@Entity
public class Employee {
	@Id // identity
	//@GeneratedValue(strategy=GenerationType.AUTO)
	
	//@GeneratedValue=(strategy=GenerationType.TABLE)
	
	//@TableGenerator(name="emp_gen") // SEQ_GEN adı emp_gen olacaktır.
	//@GeneratedValue(generator="emp_gen")
	
	@TableGenerator(name="emp_gen_detailed",
	table="ID_GEN", //id_gen adında ayrı bir tablo
	pkColumnName="ID_GEN_NAME",
	valueColumnName="ID_GEN_COUNT",
	initialValue=200, //varsayılan 0
	allocationSize=10) //varsayılan 50
	@GeneratedValue(generator="emp_gen_detailed")
	@Column(name="emp_id")

	private int id;
	private String name;
	private String surname;
	private int salary;
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public Employee() {
		super();
	}

	public Employee(String name, String surname, int salary) {
		super();

		this.name = name;
		this.surname = surname;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public void setSalary(int salaSry) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", employeeType=" + employeeType + ", date=" + date + "]";
	}

}
