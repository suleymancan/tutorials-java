package _03springaop.test;

import org.springframework.aop.framework.ProxyFactory;

import _03springaop.service.LoggerWriter;
import _03springaop.service.SimpleAfterReturningAdviceImpl;

public class SimpleAfterReturningAdviceTest {

	public static void main(String[] args) {
		LoggerWriter target = new LoggerWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleAfterReturningAdviceImpl());
		pf.setTarget(target);
		LoggerWriter proxy = (LoggerWriter) pf.getProxy();
		proxy.log();
	}
}
