package com.javalec.ex;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		String sigStr = joinpoint.getSignature().toShortString();
		System.out.println(sigStr + "is start");
		long st = System.currentTimeMillis();
		try {
			Object obj = joinpoint.proceed();
			return obj;
		}finally {
			long et = System.currentTimeMillis();
			System.out.println(sigStr + "is finished 경과시간 : " + (et - st));
		}
	}
	public void beforeAdvice(JoinPoint jp) {
		System.out.println("beforeAdvice()");
	}
	public void afterReturningAdvice() {
		System.out.println("afterReturningAdvice()");
	}
	public void afterThrowingAdvice() {
		System.out.println("afterThrowAdvice()");
	}
	public void afterAdvice() {
		System.out.println("afterAdvice()");
	}
}
