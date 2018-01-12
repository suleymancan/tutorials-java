package test;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Persistence;

import dao.EmployeeDAO;
import dao.EmployeeDAOImpl;
import model.Employee;
import model.EmployeeType;

public class EmployeeTest {

	public static void main(String[] args) {

		// EntityManagerFactory için Persistence sınıfından yararlandım.
		// Bir Persistence sınıfından birden fazla EntityManagerFactory oluşturulabilir.
		// persistence.xml'deki persistence-unit name'i verdim.
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");

		// 1 entityManagerFactory'den n tane EntityManager olusturabiliriz.
		// EntityManagerFactory, EntityManager oluşturmaktan sorumludur.
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// EntityManager, Entity objeleriyle yaptığımız işlemlerden sorumlu.
		// Veritabanına kayıt atılması, silme vs. hepsinden sorumludur.

		// EntityManager ile olusturdugumuz tüm objeler Persistence Context tarafından
		// yönetilmektedir.
		EmployeeDAO employeeDAO = new EmployeeDAOImpl(entityManager);

		
		Employee employee1 = new Employee("Suleyman", "Can", 5000);
		employee1.setEmployeeType(EmployeeType.FULL_TIME);
		
		employee1.setDate(new Date());
		Employee employee2 = new Employee("Mehmet Ali", "Can", 6000);
		employee2.setEmployeeType(EmployeeType.PART_TIME);
		
		employee2.setDate(new Date());
		Employee employee3 = new Employee("Nazlisu", "Can", 7000);
		employee3.setEmployeeType(EmployeeType.FULL_TIME);
		
		employee3.setDate(new Date());
		// ayni id ile ekleme yapınca hata verir.
		// entity class'ımızda @id anotation'unu kaldırırsak hata alırız.
		// insertEmployee'de begin commit arasına yazmazsak, db'de tablo olusur ama
		// kayıt olusmaz.

		// kayıt ekleme.
		employeeDAO.insertEmployee(employee1);
		employeeDAO.insertEmployee(employee2);
		employeeDAO.insertEmployee(employee3);

		// kayit bulma:
		Employee employeeFound = employeeDAO.getEmployeeById(1);
		System.out.println("---tek kayit---");
		System.out.println(employeeFound);
		System.out.println("---tüm liste----");
		List<Employee> listEmployee = employeeDAO.getEmployees();

		// java8 -> employeeList.forEach(System.out::println);

		for (Employee e : listEmployee) {
			System.out.println(e);
		}

		employeeDAO.deleteEmployee(1);

		System.out.println("---sildikten sonra listeleme---");

		List<Employee> listEmployee2 = employeeDAO.getEmployees();

		for (Employee e : listEmployee2) {
			System.out.println(e);
		}

		System.out.println("--guncelleme---");

		employeeDAO.raiseSalary(2, 1000);

		List<Employee> listEmployee3 = employeeDAO.getEmployees();

		for (Employee e : listEmployee3) {
			System.out.println(e);
		}
	}
}
