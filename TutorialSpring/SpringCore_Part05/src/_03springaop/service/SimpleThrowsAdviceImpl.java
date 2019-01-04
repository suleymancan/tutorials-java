package _03springaop.service;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

public class SimpleThrowsAdviceImpl implements ThrowsAdvice {

	public void afterThrowing(Exception ex) throws Throwable {
		System.out.println("---");
		System.out.println("generic exception capture1");
		System.out.println("caught:" + ex.getClass().getName());
		System.out.println("---");
	}

	public void afterThrowing(Method met, Object[] args, Object target, ArithmeticException ex) throws Throwable {
		System.out.println("---");
		System.out.println("aritmeticException capture"); // ele gecirildi
		System.out.println("caught:" + ex.getClass().getName()); // yakalandı
		System.out.println("method: " + met.getName());
		System.out.println("---");
	}

	public void afterThrowing(Method met, Object[] args, Object target, NumberFormatException ex) throws Throwable {
		System.out.println("---");
		System.out.println("numberFormatException capture");
		System.out.println("caught:" + ex.getClass().getName());
		System.out.println("method: " + met.getName());
		System.out.println("---");
	}

}
