package _03collectioninjection_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03collectioninjection_model.CollectionInjectionModel;

public class CollectionInjectionTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("collectioninjection.xml");

		CollectionInjectionModel collectionInjectionModel = context.getBean("listModel1",
				CollectionInjectionModel.class);

		System.out.println(collectionInjectionModel);

		context.close();
	}
}
