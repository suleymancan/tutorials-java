package _03.spring.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03.spring.model.Car;

public class SpringTest {
	public static void main(String[] args) {

		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("appcontext.xml");
		Car car = applicationContext.getBean("carId", Car.class);
		car.go();
	}
}
