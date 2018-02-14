package _05aspectj.annotation.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@EnableAspectJAutoProxy
public class AuditServiceAspect {

	@Before("execution(* _05aspectj.annotation.service.EmployeeService.saveEmployee(..))")
	public void logBefore() {
		System.out.println("logBefore is invoked...");
	}

	@After("execution(* _05aspectj.annotation.service.EmployeeService.updateEmployee(..))")
	public void logAfter() {
		System.out.println("logAfter is invoked...");
	}

	@AfterReturning(pointcut = "execution(* _05aspectj.annotation.service.EmployeeService.getEmployeeId(..))", returning = "resultValue")
	public void logAfterReturning(JoinPoint joinPoint, String resultValue) {
		System.out.println("logAfterReturning is invoked...");
		System.out.println("invoked by: " + joinPoint.getSignature().getName());
		System.out.println("returned value: " + resultValue);
	}

	@AfterThrowing(pointcut = "execution(* _05aspectj.annotation.service.EmployeeService.deleteEmployee(..))", throwing = "thrownException")
	public void logAfterThrowing(JoinPoint joinPoint, Exception thrownException) {
		System.out.println("logAfterThrowing is invoked...");
		System.out.println("called by: " + joinPoint.getSignature().getName());
		System.out.println("exception: " + thrownException);
	}

	@Around("execution(* _05aspectj.annotation.service.EmployeeService.getAllEmployees(..))")
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("logAround is invoked...");
		System.out.println("invoked by: " + joinPoint.getSignature().getName());
		System.out.println("around before is running");
		joinPoint.proceed();
		System.out.println("around after is running");
	}
}
