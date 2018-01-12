package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import model.Department;
import model.Employee;
import model.NickName;
import model.ParkingSpace;
import model.Phone;
import model.Project;

public class EmployeeDAOImpl implements EmployeeDAO {

	private EntityManager entityManager;

	public EmployeeDAOImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public void insertEmployee(Employee employee) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();
		// bu arada insert, delete, update islemlerini yapabiliriz.
		entityManager.persist(employee); // ilgili objeyi verdim ve persist ile kalıcı hale getirdim. (insert)

		transaction.commit();
	}

	@Override
	public Employee getEmployeeById(int id) {
		// read isleminde transaction begin/commit'e gerek yok.
		// id'ye göre kaydı getirecek ve kaydı objeye mapleyecek.
		//
		Employee employee = entityManager.find(Employee.class, id);
		return employee;
	}

	@Override
	public List<Employee> getEmployees() {
		// Select * from employee
		// buradaki Employee entity class name.
		Query query = entityManager.createQuery("Select e from Employee e"); // jpql
		// generic: typedQuery<Employee> query=entityManager.createQuery("Select e from
		// Employee e",Employee.class");
		// burada normal sql yazacagımız metotlarda var.

		return query.getResultList();

	}

	@Override
	public void deleteEmployee(int id) {

		Employee employee = getEmployeeById(id);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(employee);
		transaction.commit();

	}

	// guncelleme
	@Override
	public void raiseSalary(int id, int raise) {
		Employee employee = getEmployeeById(id);
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		employee.setSalary(employee.getSalary() + raise);
		transaction.commit();
	}

	@Override
	public void insertDepartment(Department department) {

		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		entityManager.persist(department);

		transaction.commit();

	}

	@Override
	public void insertParkingSpace(ParkingSpace parkingSpace) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		entityManager.persist(parkingSpace);

		transaction.commit();
	}

	@Override
	public void insertProject(Project project) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		entityManager.persist(project);

		transaction.commit();

	}

	@Override
	public void updateProject(Employee employee, Project project) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		employee.getProjects().add(project);

		transaction.commit();

	}

	@Override
	public void insertPhone(Phone phone) {
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		entityManager.persist(phone);

		transaction.commit();

	}

	@Override
	public void updatePhone(Employee employee, Phone phone) {
		
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		employee.getPhones().add(phone);

		transaction.commit();

	}

	@Override
	public void updateNickName(Employee employee, NickName nickName) {
	
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		employee.setNickName(nickName);

		transaction.commit();
	}

	@Override
	public void updateEmail(Employee employee, String email) {
		
		EntityTransaction transaction = entityManager.getTransaction();

		transaction.begin();

		employee.getEmails().add(email);

		transaction.commit();
	}

	// JPQL -> Sql'e benzer.
	// Entity class ile aynı isme sahip olmalıdır.
}
