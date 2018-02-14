package _03springaop.service;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class SimpleBeforeAdviceImpl implements MethodBeforeAdvice {

	// method çalışmadan önce
	@Override
	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {
		System.out.println("before method: " + arg0.getName());

	}

}
