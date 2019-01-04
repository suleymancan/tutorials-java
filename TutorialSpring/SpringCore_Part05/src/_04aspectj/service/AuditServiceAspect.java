package _04aspectj.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class AuditServiceAspect {

	public void logBefore() {
		System.out.println("---");
		System.out.println("logBefore invoked!");
	}

	public void logAfter() {
		System.out.println("logAfter invoked!");

	}
	//joinPoint yardımyla hangi metotdan  resultValue tasındığını görebiliyorz.
	public void logAfterReturning(JoinPoint joinPoint, String resultValue) {
		System.out.println("logAfterReturning invoked!");
		System.out.println("Called by: " + joinPoint.getSignature().getName());
		System.out.println("Returned value: " + resultValue);

	}
	
	//deleteEMployee'den bir exception fırlatılmışsa buraya yazıyoruz.
	public void logAfterThrowing(JoinPoint joinPoint, Exception thrownException) {
		System.out.println("logAfterThrowing is invoked!");
		System.out.println("Called by: " + joinPoint.getSignature().getName());
		System.out.println("Exception: " + thrownException);

	}
	
	
	
	public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("logAround is invoked!");
		System.out.println("Called by: " + joinPoint.getSignature().getName());
		System.out.println("Around before is running!");
		joinPoint.proceed();
		System.out.println("Around after is running!");
	}
}
