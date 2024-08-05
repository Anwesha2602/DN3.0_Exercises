package com.library.aspect;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
//	@Before("execution(* com.library.service.*.*(..))")
//	public void before(JoinPoint jointPoint) {
//		System.out.println("Before...");
//		System.out.println(jointPoint.getSignature().getName());
//	}
//	
//	@After("execution(* com.library.service.*.*(..))")
//	public void after(JoinPoint jointPoint) {
//		System.out.println("After...");
//		System.out.println(jointPoint.getSignature().getName());
//	}
//	
	@Around("execution(* com.library.service.*.*(..))")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime=System.currentTimeMillis();
		System.out.println(joinPoint.getSignature().getName()+" starts at " + startTime + " milli seconds");
		Object proceed = joinPoint.proceed();
		long endTime=System.currentTimeMillis();
		System.out.println(joinPoint.getSignature().getName()+" ends at " + endTime + " milli seconds");
		long execTime = endTime - startTime;
		System.out.println(joinPoint.getSignature()+" takes " + execTime + " ms to complete execution!");
		return proceed;
	
	}
}
