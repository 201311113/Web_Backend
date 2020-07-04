package com.javalec.ex;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {
	
	@Pointcut("within(com.javalec.ex.*)")
	public void pointcutMethod() {	
	}
	
	@Around("pointcutMethod()")
	public Object loggerAop(ProceedingJoinPoint jp) throws Throwable{
		String sig = jp.getSignature().toShortString();
		System.out.println(sig + " is start");
		long st=System.currentTimeMillis();
		try {
			Object obj = jp.proceed();
			return obj;
		}finally {
			long et = System.currentTimeMillis();
			System.out.println(sig + " is finished");
			System.out.println("경과시간 : " +(et - st));
		}
	}
	
}
