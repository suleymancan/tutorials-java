package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EnumType;
import javax.persistence.Persistence;
import javax.persistence.Tuple;

import dao.EmployeeDAO;
import dao.EmployeeDAOCriteria;
import dao.EmployeeDAOCriteriaImpl;
import dao.EmployeeDAOImpl;
import model.Department;
import model.Employee;
import model.EmployeeDetails;
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
		// eclipselink:
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("EmployeePersistenceUnit");
		// hibernate:
		// EntityManagerFactory entityManagerFactory =
		// Persistence.createEntityManagerFactory("EmployeePersistenceUnitForHibernate");

		// 1 entityManagerFactory'den n tane EntityManager olusturabiliriz.
		// EntityManagerFactory, EntityManager oluşturmaktan sorumludur.
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// EntityManager, Entity objeleriyle yaptığımız işlemlerden sorumlu.
		// Veritabanına kayıt atılması, silme vs. hepsinden sorumludur.

		// EntityManager ile olusturdugumuz tüm objeler Persistence Context tarafından
		// yönetilmektedir.
		EmployeeDAO employeeDAO = new EmployeeDAOImpl(entityManager);
		EmployeeDAOCriteria employeeDAOCriteria=new EmployeeDAOCriteriaImpl(entityManager);
		Employee employee1 = new Employee("Suleyman", "Can", 5000);
		employee1.setEmployeeType(EmployeeType.FULL_TIME);

		employee1.setDate(new Date());

		Department software = new Department("Software");
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

		ParkingSpace ps1 = new ParkingSpace(3, "A27");
		ParkingSpace ps2 = new ParkingSpace(2, "B27");
		ParkingSpace ps3 = new ParkingSpace(1, "C27");
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

		Phone phone1 = new Phone("123", PhoneType.TURKTELEKOM);
		Phone phone2 = new Phone("456", PhoneType.TURKCELL);
		Phone phone3 = new Phone("789", PhoneType.VODAFONE);

		employeeDAO.insertPhone(phone1);
		employeeDAO.insertPhone(phone2);
		employeeDAO.insertPhone(phone3);

		employeeDAO.updatePhone(employee1, phone1);
		employeeDAO.updatePhone(employee2, phone2);
		employeeDAO.updatePhone(employee3, phone3);

		NickName nm = new NickName("kardesler kundura");
		employeeDAO.updateNickName(employee1, nm);
		employeeDAO.updateNickName(employee2, nm);
		employeeDAO.updateNickName(employee3, nm);

		String email1 = "a@b.com";
		String email2 = "c@d.com";
		String email3 = "e@f.com";

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
		System.out.println("---employee names---");
		List<String> listNameEmployee = employeeDAO.getEmployeeNames();
		for (String s : listNameEmployee) {
			System.out.println(s);
		}

		System.out.println("--jpql sorguya parametre ekleme---");
		String employeeName = employeeDAO.getEmployeeNameById(2);
		System.out.println(employeeName);

		System.out.println("---birden fazla sutun dönme---");
		List<Object[]> nameAndSurname = employeeDAO.getEmployeeNameAndSurname();
		for (Object[] o : nameAndSurname) {
			System.out.println("isim: " + o[0] + " soyisim: " + o[1]);
		}

		System.out.println("-constructor expression---");

		List<EmployeeDetails> employeeDetails = employeeDAO.getEmployeeConstructorExpression();

		for (EmployeeDetails l : employeeDetails) {
			System.out.println(l);
		}

		System.out.println("---employee named query---");

		List<Integer> namedQuerySalary = employeeDAO.getEmployeeNamedQuery();

		for (Integer s : namedQuerySalary) {
			System.out.println(s);
		}

		System.out.println("---employee and phone join ---");
		List<Object[]> employeeAndPhone = employeeDAO.joinEmployeeAndPhone();
		for (Object[] o : employeeAndPhone) {
			System.out.println("isim: " + o[0] + ", phone:" + o[1] + ", phone type: " + o[2]);
		}

		System.out.println("---left outer join---");
		Employee employee4=new Employee("Kıymet","Can",8000);
		Employee employee5=new Employee("Haci","Can",10000);
		Department department2=new Department("Test Enginering");
		Department department3=new Department("Software Enginering");
		employeeDAO.insertDepartment(department2);
		employeeDAO.insertDepartment(department3);
		employee4.setDepartment(department2);
		employee5.setDepartment(department3);
		employeeDAO.insertEmployee(employee4);
		employeeDAO.insertEmployee(employee5);
		
		List<Object[]> leftOuter=employeeDAO.leftOuterJoin();
		for(Object[] o : leftOuter) {
			System.out.println(o[0]+" " + o[1]);
		}
		
		System.out.println("---between query---");
		List<Employee> betweenQuery=employeeDAO.betweenQuery(3000, 7000);
		for(Employee e: betweenQuery) {
			System.out.println(e);
		}

		System.out.println("--- like query ---");
		List<Department> likeQuery=employeeDAO.likeQuery("%eng%");
		for(Department d : likeQuery)
			System.out.println(d);
		System.out.println("---inQuery---");
		List<Employee> inQuery=employeeDAO.inQuery("Software", "Test Enginering");
		for(Employee e : inQuery)
			System.out.println(e);
		
		System.out.println("---all query---");
		List<Employee> allQuery=employeeDAO.allQuery(1);
		for(Employee e : allQuery) {
			System.out.println(e);
		}
		 
		System.out.println("---kümeleme query---");
		List<Object[]> kumelemeQuery=employeeDAO.kumelemeQuery();
		for(Object[] o: kumelemeQuery) {
			System.out.println("en yuksek maas:"+o[0]+", en dusuk maas:"+o[1]+", toplam maas: "+o[2]+", toplam kisi: "+o[3]+", ortalama maas: "+o[4]);
		}
		
		System.out.println("--group by---");
		List<Object[]> groupByQuery=employeeDAO.groupByQuery();
		for(Object[] o : groupByQuery) {
			System.out.println("departman adı: "+o[0]+", ortalama maas: "+o[1]);
		}
		
		System.out.println("---having---");
		List<Object[]> havingQuery=employeeDAO.havingQuery(8000);
		for(Object[] o : havingQuery)
			System.out.println("ortalama maaas 8000'den buyuk olan departman adı: "+o[0]+", maas:"+o[1]);

		System.out.println("---order by---");
		List<Employee> orderByQuery=employeeDAO.orderByQuery();
		for(Employee e : orderByQuery)
			System.out.println(e);		
		
		System.out.println("---criteria api findAllEmployeesWithCriteria---");
		
		List<Employee> allEmployeesCriteria=employeeDAOCriteria.findAllEmployeesWithCriteria();
		for(Employee e : allEmployeesCriteria)
			System.out.println(e);
		
		System.out.println("--criteria api getAllEmployeesNameWithCriteria---");
		List<String> allEmployeesNamesCriteria=employeeDAOCriteria.getAllEmployeesNameWithCriteria();
		for(String s: allEmployeesNamesCriteria)
			System.out.println(s);
		
		System.out.println("---criteria api tuple getEmployeeInformationWithCriteria---");
		List<Tuple> employeeInformationCriteria=employeeDAOCriteria.getEmployeeInformationWithCriteria();
		for(Tuple t : employeeInformationCriteria)
			System.out.println("employee name: "+t.get(0)+", employee salary: "+t.get(1)+ ", employee department name: "+t.get(2));
		System.out.println();
		System.out.println("---criteria api where getDepartmentWithCriteria---");
		String deptName=employeeDAOCriteria.getDepartmentWithCriteria("Nazlisu");
		System.out.println("Nazlısu departman adı: "+deptName);
		
		System.out.println("---criteria api ConstructorExpression --- ");
		List<EmployeeDetails> constructorExptression=employeeDAOCriteria.getEmployeeDetails();
		for(EmployeeDetails e: constructorExptression)
			System.out.println(e);
		
		System.out.println("---criteria api CriteriaAPI JOIN---");
		String deptName2=employeeDAOCriteria.getDepartmentOfEmployeeCriteriaJoin("Suleyman");
		System.out.println(deptName2);
		
		System.out.println("---criteria api Greater THAN---");
		List<Tuple> greaterThan=employeeDAOCriteria.getEmployeeNameSalaryGreaterThan(6000);
		for(Tuple t: greaterThan)
			System.out.println(t.get(0)+" "+t.get(1));
		
		System.out.println("---criteria api BETWEEN---");
		List<Tuple> between=employeeDAOCriteria.getEmployeeNameSalaryBetween(7000, 11000);
		for(Tuple t: between)
			System.out.println(t.get(0)+ " "+t.get(1));
		
		System.out.println("---criteria api LIKE---");
		List<Tuple> like=employeeDAOCriteria.getEmployeeNameSalaryLike("%a%");
		for(Tuple t: like)
			System.out.println(t.get(0)+" "+t.get(1)); 
		  
		
		System.out.println("---criteria api IN---");
		List<Integer> salaries= new ArrayList<Integer>();
		salaries.add(5000);
		salaries.add(8000);
		salaries.add(10000);
		List<Tuple> in=employeeDAOCriteria.getEmployeeNameSalaryIn(salaries);
		for(Tuple t: in)
			System.out.println(t.get(0)+" "+ t.get(1));
		
		System.out.println("---criteria api ISNULL");
		Employee employee6=new Employee("Tulay","Can",11000);
		Employee employee7=new Employee("Elif","Can",12000);
		employeeDAO.insertEmployee(employee6);
		employeeDAO.insertEmployee(employee7);
		List<String> isNull=employeeDAOCriteria.getDepartmentOfEmployeeIsNull();
		for(String s : isNull)
			System.out.println(s);
	}
}
