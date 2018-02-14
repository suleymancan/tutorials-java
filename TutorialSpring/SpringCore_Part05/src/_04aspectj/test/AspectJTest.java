package _04aspectj.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _04aspectj.service.EmployeeService;

public class AspectJTest {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("aspectj.xml");

		EmployeeService empService = context.getBean("employeeService", EmployeeService.class);

		// aop:before
		empService.saveEmployee();
		System.out.println("---");

		// aop:after
		empService.updateEmployee();
		System.out.println("---");

		// aop:after-returning
		empService.getEmployeeId();
		System.out.println("---");

		// aop:after-throwing
		try {
			empService.deleteEmployee();
		} catch (Exception e) {
		}
		System.out.println("---");

		// aop:around
		empService.getAllEmployees();

	}

}
