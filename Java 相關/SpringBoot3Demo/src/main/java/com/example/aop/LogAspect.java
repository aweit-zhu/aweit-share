package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Before("execution(* com.example.controller.*.*(..))")
    public void logBefore(JoinPoint joinPoint) {
		logger.info( "Executing: {}" , joinPoint.getSignature().toShortString());
    }

    @Around("execution(* com.example.controller.*.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();

        Object proceed = joinPoint.proceed();

        long executionTime = System.currentTimeMillis() - start;

        logger.info("{} executed in {} ",joinPoint.getSignature().toShortString(), executionTime + "ms");

        return proceed;
    }
}
