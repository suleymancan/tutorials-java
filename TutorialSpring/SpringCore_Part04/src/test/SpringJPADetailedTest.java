package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PersonDAOJPADetailed;
import dao.PersonDAOJPADetailedImpl;
import model.Person;

public class SpringJPADetailedTest {

	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("jpa.detailed.xml");
		PersonDAOJPADetailed dao=context.getBean(PersonDAOJPADetailedImpl.class);
		
		Person p1=new Person("Yiğit", "CAN", 2010);
		Person p2=new Person("Ali Efe", "CAN", 2010);
		
		dao.insert(p1); 
		dao.insert(p2);
	}
}
