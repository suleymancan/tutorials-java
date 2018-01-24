package _04javabased.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import _04javabased.configuration.SpringConfiguration;
import _04javabased.model.Brother;

public class JavaBasedConfigurationTest {

	public static void main(String[] args) {
		// java based'da kullandıgımız class'ımız farklı.
		ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		Brother bro = context.getBean(Brother.class);
		System.out.println(bro);
	}
}
