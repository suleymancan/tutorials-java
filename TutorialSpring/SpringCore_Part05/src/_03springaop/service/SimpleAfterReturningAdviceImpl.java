package _03springaop.service;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class SimpleAfterReturningAdviceImpl implements AfterReturningAdvice {
	
	//methoddan sonra
	@Override
	public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
		System.out.println("after method: "+ arg1.getName());
		
	}

}
