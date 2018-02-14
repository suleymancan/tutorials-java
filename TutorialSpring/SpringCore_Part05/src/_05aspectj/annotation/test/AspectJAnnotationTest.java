package _05aspectj.annotation.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _05aspectj.annotation.service.EmployeeService;

public class AspectJAnnotationTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("aspectj.annotation.xml");
		EmployeeService employeeService = context.getBean(EmployeeService.class);

		// @Before
		employeeService.saveEmployee();

		System.out.println("---");
		// @After
		employeeService.updateEmployee();

		// @AfterReturning
		System.out.println("---");
		employeeService.getEmployeeId();

		// @AfterThrowing
		System.out.println("---");
		try {
			employeeService.deleteEmployee();
		} catch (Exception e) {

		}

		// @Around
		System.out.println("---");
		employeeService.getAllEmployees();

		context.close();
	}
}
