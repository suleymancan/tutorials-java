package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import model.Department;
import model.Employee;
import model.EmployeeDetails;
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

	@Override
	public List<String> getEmployeeNames() {
		TypedQuery<String> query = entityManager.createQuery("Select e.name from Employee e", String.class);
		return query.getResultList();

	}

	@Override
	public String getEmployeeNameById(int id) {
		//// positional binding yaklasımı:
		// TypedQuery<String> query=entityManager.createQuery("Select e.name from
		// Employee e where e.id=?1",String.class).setParameter(1, id);
		// namedParameter yaklasımı:
		TypedQuery<String> query = entityManager
				.createQuery("Select e.name from Employee e where e.id=:myEmployeeId", String.class)
				.setParameter("myEmployeeId", id);
		return query.getSingleResult(); // tek deger donuyor.sonuc bulamazsa exception atar.

	}

	@Override
	public List<Object[]> getEmployeeNameAndSurname() {
		// 0. indekse name'i, 1. indekse surname'i koyar.
		TypedQuery<Object[]> query = entityManager.createQuery("Select e.name, e.surname from Employee e",
				Object[].class);
		return query.getResultList();

	}

	@Override
	public List<EmployeeDetails> getEmployeeConstructorExpression() {
		TypedQuery<EmployeeDetails> query = entityManager.createQuery(
				"Select New model.EmployeeDetails(e.name, e.surname, e.department.name) from Employee e ",
				EmployeeDetails.class);
		return query.getResultList();
	}

	@Override
	public List<Integer> getEmployeeNamedQuery() {
		TypedQuery<Integer> query = entityManager.createNamedQuery("Employee.getEmployeeSalary", Integer.class);
		return query.getResultList();
	}

	@Override
	public List<Object[]> joinEmployeeAndPhone() {
		TypedQuery<Object[]> query = entityManager
				.createQuery("SELECT e.name, p.number, p.phoneType FROM Employee e JOIN e.phones p", Object[].class);
		return query.getResultList();
	}

	@Override
	public List<Object[]> leftOuterJoin() {
		TypedQuery<Object[]> query = entityManager
				.createQuery("Select e.name , d.name From Employee e LEFT JOIN e.department d", Object[].class);
		return query.getResultList();
	}

	@Override
	public List<Employee> betweenQuery(int minMaas, int maxMaas) {
		TypedQuery<Employee> query = entityManager
				.createQuery("Select e from Employee e where e.salary BETWEEN ?1 and ?2", Employee.class)
				.setParameter(1, minMaas).setParameter(2, maxMaas);
		return query.getResultList();

	}

	@Override
	public List<Department> likeQuery(String like) {
		TypedQuery<Department> query = entityManager
				.createQuery("Select d from Department d where d.name LIKE ?1", Department.class).setParameter(1, like);
		return query.getResultList();

	}

	@Override
	public List<Employee> inQuery(String project1Name, String project2Name) {

		TypedQuery<Employee> query = entityManager
				.createQuery("Select e from Employee e where e.department.name IN(?1,?2)", Employee.class)
				.setParameter(1, project1Name).setParameter(2, project2Name);
		return query.getResultList();
	}

	@Override
	public List<Employee> allQuery(int depId) {
		TypedQuery<Employee> query = entityManager.createQuery(
				"Select e from Employee e where e.salary>ALL(Select e2.salary from Employee e2 where e2.department.id=?1)",
				Employee.class).setParameter(1, depId);
		return query.getResultList();
	}

	@Override
	public List<Object[]> kumelemeQuery() {
		TypedQuery<Object[]> query = entityManager.createQuery(
				"Select MAX(e.salary), MIN(e.salary), SUM(e.salary), COUNT(e.id), AVG(e.salary) from Employee e",
				Object[].class);
		return query.getResultList();
	}

	@Override
	public List<Object[]> groupByQuery() {

		TypedQuery<Object[]> query = entityManager.createQuery(
				"Select e.department.name, AVG(e.salary) from Employee e GROUP BY e.department.name", Object[].class);
		return query.getResultList();
	}

	@Override
	public List<Object[]> havingQuery(int maas) {
		TypedQuery<Object[]> query = entityManager.createQuery(
				"Select e.department.name, AVG(e.salary) from Employee e GROUP BY e.department.name HAVING AVG(e.salary)>?1 ",
				Object[].class).setParameter(1, maas);
		return query.getResultList();
	}

	@Override
	public List<Employee> orderByQuery() {
	
	TypedQuery<Employee> query= entityManager.createQuery("Select e from Employee e ORDER BY e.salary DESC",Employee.class);
	return query.getResultList();
	}


	// JPQL -> Sql'e benzer.
	// Entity class ile aynı isme sahip olmalıdır.
}
