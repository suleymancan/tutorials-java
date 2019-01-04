package _02jpadeclarative.transaction.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import _02jpadeclarative.transaction.model.Adress;
import _02jpadeclarative.transaction.model.Customer;
import _02jpadeclarative.transaction.service.CustomerService;

public class SpringJPADeclarativeTransactionTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("jpa.declarative.transaction.xml");

		// get CustomerService bean
		CustomerService customerService = context.getBean(CustomerService.class);

		Customer customer1 = new Customer(1, "Süleyman", "Can");
		Adress adress1 = new Adress(1, "caydacira", "23200", "Elazig");
		customer1.setAdress(adress1);

		Customer c2 = new Customer(2, "Nazlisu", "CAN");
		Adress adress2 = new Adress(2, "kolejtepe", "27200", "GAziantep");
		c2.setAdress(adress2);

		Customer c3 = new Customer(3, "Memos", "CAn");
		// duplicate adreesId, throw!
		// rollback.
		Adress adress3 = new Adress(2, "hosgor", "27300", "Gaziantep");
		c3.setAdress(adress3);

		customerService.insertCustomerData(customer1);
		customerService.insertCustomerData(c2);

		try {
			customerService.insertCustomerData(c3);
		} catch (Exception e) {
			System.out.println("rolback...");
			System.out.println(e.getMessage());
		}

		System.out.println("----");
		for (Customer cr : customerService.listCustomers()) {
			System.out.println(cr);
		}
		context.close();
	}
}
