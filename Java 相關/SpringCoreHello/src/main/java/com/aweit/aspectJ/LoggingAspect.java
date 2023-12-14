package com.aweit.aspectJ;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

	@Before("execution(* com.aweit.aop.CustomerServiceImpl.*(..))")
	public void logBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("前置通知 Log: {}, {}", methodName, Arrays.toString(args));
	}
	
	@AfterReturning(value = "execution(* com.aweit.aop.CustomerServiceImpl.*(..))", returning = "result")
	public void logBefore(JoinPoint joinPoint,String result) {
		String methodName = joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("{}方法執行後,回傳值:{}", methodName, result);
	}
	
	@AfterThrowing(value = "execution(* com.aweit.aop.CustomerServiceImpl.*(..))", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		logger.error("異常通知 Log: {}", ex);
	}
}
