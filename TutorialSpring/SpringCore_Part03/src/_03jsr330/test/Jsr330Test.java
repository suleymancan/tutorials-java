package _03jsr330.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import _03jsr330.model.Student;
import _03jsr330.service.StudentService;
import _03jsr330.service.StudentServiceImpl;

public class Jsr330Test {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("03.jsr330.xml");
		StudentService sService = context.getBean("sService", StudentServiceImpl.class);

		Student student = new Student();
		student.setName("Mehmet Ali");
		student.setSurname("Can");
		sService.insertStudent(student);
	}
}
