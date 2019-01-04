package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;

import model.Department;
import model.Employee;
import model.EmployeeDetails;

public class EmployeeDAOCriteriaImpl implements EmployeeDAOCriteria {

	private EntityManager entityManager;

	public EmployeeDAOCriteriaImpl(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAllEmployeesWithCriteria() {

		// 1-) CriteriaBuilder objesi olusturulur. Criteria'nın ana giris noktası.
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

		// CriteriaQuery, Query'nin alt sınıfı degildir.
		CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
		// root of query
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(empRoot);
		// Select e from Employee e
		TypedQuery<Employee> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	@Override
	public List<String> getAllEmployeesNameWithCriteria() {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(empRoot.get("name"));
		TypedQuery<String> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	@Override
	public List<Tuple> getEmployeeInformationWithCriteria() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		// Tuple çok öğeli, çok elemanlı gibi anlamlara gelmektedir.
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createQuery(Tuple.class);
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary"),
				empRoot.get("department").get("name")));
		TypedQuery<Tuple> typedQuery = entityManager.createQuery(criteriaQuery);
		return typedQuery.getResultList();
	}

	@Override
	public String getDepartmentWithCriteria(String employee) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(empRoot.get("department").get("name"))
				.where(criteriaBuilder.equal(empRoot.get("name"), employee));
		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);

		return query.getSingleResult();
	}

	@Override
	public List<EmployeeDetails> getEmployeeDetails() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<EmployeeDetails> criteriaQuery = criteriaBuilder.createQuery(EmployeeDetails.class);
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);

		criteriaQuery.select(criteriaBuilder.construct(EmployeeDetails.class, empRoot.get("name"),
				empRoot.get("surname"), empRoot.get("department").get("name")));
		TypedQuery<EmployeeDetails> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public String getDepartmentOfEmployeeCriteriaJoin(String Employee) {

		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = criteriaBuilder.createQuery(String.class);
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);

		Join<Employee, Department> departmentJoin = empRoot.join("department");
		criteriaQuery.select(departmentJoin.get("name")).where(criteriaBuilder.equal(empRoot.get("name"), Employee));

		TypedQuery<String> query = entityManager.createQuery(criteriaQuery);
		return query.getSingleResult();

	}

	@Override
	public List<Tuple> getEmployeeNameSalaryGreaterThan(int salary) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		ParameterExpression<Integer> salaryExpression = criteriaBuilder.parameter(Integer.class, "salaryParam");
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));
		criteriaQuery.where(criteriaBuilder.greaterThan(empRoot.get("salary"), salaryExpression));
		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery).setParameter(salaryExpression, salary);
		return query.getResultList();

	}

	@Override
	public List<Tuple> getEmployeeNameSalaryBetween(int salary, int salary2) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));
		criteriaQuery.where(
				criteriaBuilder.between(empRoot.get("salary"), criteriaBuilder.parameter(Integer.class, "lowSalary"),
						criteriaBuilder.parameter(Integer.class, "highSalary")));
		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery).setParameter("lowSalary", salary)
				.setParameter("highSalary", salary2);
		return query.getResultList();
	}

	@Override
	public List<Tuple> getEmployeeNameSalaryLike(String like) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));
		criteriaQuery.where(criteriaBuilder.like(empRoot.get("name"), like));

		TypedQuery<Tuple> query = entityManager.createQuery(criteriaQuery);
		return query.getResultList();

	}

	@Override
	public List<Tuple> getEmployeeNameSalaryIn(List<Integer> salaries) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = criteriaBuilder.createTupleQuery();
		Root<Employee> empRoot = criteriaQuery.from(Employee.class);
		criteriaQuery.select(criteriaBuilder.tuple(empRoot.get("name"), empRoot.get("salary")));
		//criteriaQuery.where(criteriaBuilder.in(empRoot.get("salary")).value(salaries.get(0)).value(salaries.get(1))
			//	.value(salaries.get(2)));
		// 2.yontem
		 criteriaQuery.where(empRoot.get("salary").in(salaries));
		
		TypedQuery<Tuple> query=entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<String> getDepartmentOfEmployeeIsNull() {
		CriteriaBuilder criteriaBuilder=entityManager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery=criteriaBuilder.createQuery(String.class);
		Root<Employee> empRoot=criteriaQuery.from(Employee.class);
		criteriaQuery.select(empRoot.get("name")).where(criteriaBuilder.isNull(empRoot.get("department")));
		TypedQuery<String>query=entityManager.createQuery(criteriaQuery);
		return query.getResultList();
	}

}
