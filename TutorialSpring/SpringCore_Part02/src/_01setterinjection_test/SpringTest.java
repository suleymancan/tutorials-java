package _01setterinjection_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _01setterinjection_model.Employee;

public class SpringTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("setterinjectoin.xml");

		Employee employee1 = context.getBean("emp1", Employee.class); // dependency lookup
		System.out.println(employee1);

		Employee employee2 = context.getBean("emp2", Employee.class);
		System.out.println(employee2);

		Employee employee3 = context.getBean("emp3", Employee.class);
		System.out.println(employee3);

		// bu örnekten önce department modeli eklendi, employee modelinde degisiklik
		// yapıldı.
		Employee employee4 = context.getBean("emp4", Employee.class);
		System.out.println(employee4);

		context.close();
	}
}
