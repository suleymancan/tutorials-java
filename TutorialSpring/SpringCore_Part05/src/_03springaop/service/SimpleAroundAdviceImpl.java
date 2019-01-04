package _03springaop.service;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class SimpleAroundAdviceImpl implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		System.out.println("önce!");
		Object retVal = arg0.proceed();
		System.out.println("sonra!");
		return retVal;
	}

}
