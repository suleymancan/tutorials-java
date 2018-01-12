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
import model.Department;
import model.Employee;
import model.EmployeeType;
import model.NickName;
import model.ParkingSpace;
import model.Phone;
import model.PhoneType;
import model.Project;

public class EmployeeTest {

	public static void main(String[] args) {

		// EntityManagerFactory için Persistence sınıfından yararlandım.
		// Bir Persistence sınıfından birden fazla EntityManagerFactory oluşturulabilir.
		// persistence.xml'deki persistence-unit name'i verdim.
		//eclipselink:
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		//hibernate:
		//EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");

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
		
		Department software=new Department ("Software");
		employeeDAO.insertDepartment(software);
		
		
		employee1.setDepartment(software);
		
		Employee employee2 = new Employee("Mehmet Ali", "Can", 6000);
		employee2.setEmployeeType(EmployeeType.PART_TIME);
		
		employee2.setDepartment(software);
		
		employee2.setDate(new Date());
		Employee employee3 = new Employee("Nazlisu", "Can", 7000);
		employee3.setEmployeeType(EmployeeType.FULL_TIME);
		employee3.setDepartment(software);
		employee3.setDate(new Date());
		// ayni id ile ekleme yapınca hata verir.
		// entity class'ımızda @id anotation'unu kaldırırsak hata alırız.
		// insertEmployee'de begin commit arasına yazmazsak, db'de tablo olusur ama
		// kayıt olusmaz.
		
		
		ParkingSpace ps1=new ParkingSpace(3, "A27");
		ParkingSpace ps2=new ParkingSpace(2, "B27");
		ParkingSpace ps3=new ParkingSpace(1, "C27");
		employeeDAO.insertParkingSpace(ps1);
		employeeDAO.insertParkingSpace(ps2);
		employeeDAO.insertParkingSpace(ps3);
		
		employee1.setParkingSpace(ps1);
		employee2.setParkingSpace(ps2);
		employee3.setParkingSpace(ps3);
		
		//
		
		Project project1 = new Project("FÜ Project");
		Project project2 = new Project("GAÜN Project");
		Project project3 = new Project("AİA ATML Project");
		
		employeeDAO.insertProject(project1); 
		employeeDAO.insertProject(project2);
		employeeDAO.insertProject(project3);
		

		// kayıt ekleme.
		employeeDAO.insertEmployee(employee1);
		employeeDAO.insertEmployee(employee2);
		employeeDAO.insertEmployee(employee3);
		
		employeeDAO.updateProject(employee1, project1);
		employeeDAO.updateProject(employee1, project2);
		employeeDAO.updateProject(employee1, project3);
		employeeDAO.updateProject(employee2, project1);
		employeeDAO.updateProject(employee2, project2);
		employeeDAO.updateProject(employee3, project3);
		
		

		Phone phone1=new Phone("123", PhoneType.TURKTELEKOM);
		Phone phone2=new Phone("456", PhoneType.TURKCELL);
		Phone phone3=new Phone("789", PhoneType.VODAFONE);
		
		
		employeeDAO.insertPhone(phone1);
		employeeDAO.insertPhone(phone2);
		employeeDAO.insertPhone(phone3);
		
		 employeeDAO.updatePhone(employee1, phone1);
		 employeeDAO.updatePhone(employee2, phone2);
		 employeeDAO.updatePhone(employee3, phone3);
		
		 NickName nm=new NickName("kardesler kundura");
		 employeeDAO.updateNickName(employee1, nm);
		 employeeDAO.updateNickName(employee2, nm);
		 employeeDAO.updateNickName(employee3, nm);
		 
		 String email1="a@b.com";
		 String email2="c@d.com";
		 String email3="e@f.com";
		
		 employeeDAO.updateEmail(employee1, email1);
		 employeeDAO.updateEmail(employee2, email2);
		 employeeDAO.updateEmail(employee3, email3);
		 
		 

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



		System.out.println("--guncelleme---");

		employeeDAO.raiseSalary(2, 1000);

		List<Employee> listEmployee3 = employeeDAO.getEmployees();

		for (Employee e : listEmployee3) {
			System.out.println(e);
		}
	}
}
