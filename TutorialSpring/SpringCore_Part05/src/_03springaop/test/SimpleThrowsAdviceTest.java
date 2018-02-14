package _03springaop.test;

import org.springframework.aop.framework.ProxyFactory;

import _03springaop.service.SimpleThrowsAdviceImpl;
import _03springaop.service.Validator;

public class SimpleThrowsAdviceTest {

	public static void main(String[] args) throws Exception {
		Validator errorBean = new Validator();

		ProxyFactory pf = new ProxyFactory();
		pf.setTarget(errorBean);
		pf.addAdvice(new SimpleThrowsAdviceImpl());
		Validator validator = (Validator) pf.getProxy();

		try {
			validator.validateAge(-10);

		} catch (ArithmeticException e) {
			System.out.println("aritmethic exception!#catcih");
		}

		try {
			validator.parseAge("exception");
		} catch (NumberFormatException e) {
			System.out.println("number format exception!#catch");
		}
		try {
			validator.throwRunTimeException();
		} catch (RuntimeException e) {
			System.out.println("runtimeException#catch");
		}
	}
}
