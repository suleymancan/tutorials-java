package test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.PersonHibernateDAO;
import dao.PersonHibernateDAOImpl;
import model.Person;

public class SpringHibernateTest {

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("hibernate.xml");
		PersonHibernateDAO dao = context.getBean(PersonHibernateDAOImpl.class);

		Person p1 = new Person("test name", "test surname", 2018);
		dao.insert(p1);
	}
}
