package _03springaop.test;

import org.springframework.aop.framework.ProxyFactory;

import _03springaop.service.LoggerWriter;
import _03springaop.service.SimpleAroundAdviceImpl;

public class SimpleAroundAdviceTest {

	public static void main(String[] args) {
		LoggerWriter target = new LoggerWriter();
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new SimpleAroundAdviceImpl());
		pf.setTarget(target);
		LoggerWriter proxy = (LoggerWriter) pf.getProxy();
		proxy.log();
	}
}
