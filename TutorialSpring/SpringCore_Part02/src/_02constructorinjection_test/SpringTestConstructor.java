package _02constructorinjection_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02constructorinjection_model.ConstructorConfuse;
import _02constructorinjection_model.Person;

public class SpringTestConstructor {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("constructorinjection.xml");

		Person person1 = context.getBean("person1", Person.class);
		System.out.println(person1);
		// person2 olusturup aynı getBean'i gösterse bu ikisi birbirine esit olur.

		Person person2 = context.getBean("person2", Person.class);
		System.out.println(person2);

		Person person3 = context.getBean("person3", Person.class);
		System.out.println(person3);

		// string calisir.
		ConstructorConfuse cf = context.getBean("constructorConfuse1", ConstructorConfuse.class);
		System.out.println(cf);

		ConstructorConfuse cf2 = context.getBean("constructorConfuse2", ConstructorConfuse.class);
		System.out.println(cf2);

	}

}
