package _03collectioninjection_test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03collectioninjection_model.CollectionInjectionModelAnotation;

public class CollectionInjectionAnnotationTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("anotationcollectioninjection.xml");

		CollectionInjectionModelAnotation cima = context.getBean("collectionInjectionModelAnnotation1",
				CollectionInjectionModelAnotation.class);

		System.out.println(cima);
	}
}
