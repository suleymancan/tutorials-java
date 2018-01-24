package _01autowired.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01autowired.model.Employee;

public class AutowiredTest {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("01.autowired.xml");
		Employee employee = context.getBean("emp1", Employee.class);
		System.out.println(employee);
	}
}
