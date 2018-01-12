package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//entity class ozellikllerini sagladı. (5 ozellik vardı)
// entity ve id anotationu minimum gerekli olan anatationlardır.
@Entity

@NamedQuery(name="Employee.getAll", query="Select e from Employee e")
@NamedQueries({
	@NamedQuery(name="Employee.getEmployeeSalary",query="Select e.salary from Employee e"),
	@NamedQuery(name="Empoyee.getEmployeeSurname", query="Select e.surname from Employee e")
})
public class Employee {
	@Id // identity
	// @GeneratedValue(strategy=GenerationType.AUTO)

	// @GeneratedValue=(strategy=GenerationType.TABLE)

	// farklı tablolarda farklı id degerleri kullanmak:
	// @TableGenerator(name="emp_gen") // SEQ_GEN adı emp_gen olacaktır.
	// @GeneratedValue(generator="emp_gen")

	/*
	 * @TableGenerator(name="emp_gen_detailed", table="ID_GEN", //id_gen adında ayrı
	 * bir tablo pkColumnName="ID_GEN_NAME", valueColumnName="ID_GEN_COUNT",
	 * initialValue=200, //varsayılan 0 allocationSize=10) //varsayılan 50
	 * 
	 * @GeneratedValue(generator="emp_gen_detailed")
	 * 
	 * @Column(name="emp_id")
	 */

	@TableGenerator(name = "emp_gen")
	@GeneratedValue(generator = "emp_gen")
	@Column(name = "emp_id")
	private int id;
	private String name;
	private String surname;
	private int salary;
	@Enumerated(EnumType.STRING)
	private EmployeeType employeeType;
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date date;
	
	// @Embedded
	//bu degeri employee tablosuna gömecek.
	@Embedded
	private NickName nickName;
	
	@ElementCollection
	private List<String> emails= new ArrayList<String>();
	

	public List<String> getEmails() {
		return emails;
	}

	public void setEmails(List<String> emails) {
		this.emails = emails;
	}

	public NickName getNickName() {
		return nickName;
	}

	public void setNickName(NickName nickName) {
		this.nickName = nickName;
	}

	// ### Relationship ####
	//
	// -> many: employee
	// -> one: department
	// varsayılan olarak foreign key colonu department_deptablosununidadi olacaktır.
	// bunu degistirmek icin
	// @JoinColumn(name="dept_id") vs.
	@ManyToOne
	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

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
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary + "]";
	}

	// ### Relationship ####
	// -> one: employee
	// -> one: parkingSpace
	@OneToOne
	private ParkingSpace parkingSpace;

	public ParkingSpace getParkingSpace() {
		return parkingSpace;
	}

	public void setParkingSpace(ParkingSpace parkingSpace) {
		this.parkingSpace = parkingSpace;
	}

	@ManyToMany
	@JoinTable(name = "EMP_PRJ", joinColumns = @JoinColumn(name = "EMP_ID"), inverseJoinColumns = @JoinColumn(name = "PRJ_ID"))
	List<Project> projects;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@OneToMany
	List<Phone> phones = new ArrayList<Phone>();

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}



}
