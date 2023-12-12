package com.aweit.aop;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	@Autowired
	private HttpSession session; 
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	@Pointcut("execution(* com.aweit.controller.*.*(..))")
	public void p1() {}
	
	//@Before("p1()")
	public void logBefore(JoinPoint joinPoint) {
		String methodName = joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("exec: {}, {}, {}",session.getAttribute("username"), methodName, Arrays.toString(args));
	}
	
	@AfterReturning(value = "p1()", returning = "result")
	public void logAfter(JoinPoint joinPoint, Object result) {
		String methodName = joinPoint.getTarget().getClass().getName()+"."+joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("exec: {}, {}, {}",session.getAttribute("username"), methodName, Arrays.toString(args),result);
	}
	
	@AfterThrowing(value = "p1()", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		logger.error("ex: {} Log: {}",session.getAttribute("username"), ex);
	}
}
