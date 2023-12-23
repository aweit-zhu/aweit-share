package com.example.aop;

import java.util.Arrays;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class VideoAspect {

	@Autowired
	private HttpSession session; 
	
	private static final Logger logger = LoggerFactory.getLogger(VideoAspect.class);

	@Pointcut("execution(* com.example.controller.*.*(..))")
	public void p1() {}
	
	@Pointcut("execution(* com.example.interceptor.*.preHandle(..))")
	public void p2() {}

	@AfterReturning(value = "p1() || p2()", returning = "result")
	public void afterVedio(JoinPoint joinPoint,Object result) {
		String methodName = joinPoint.getTarget().getClass().getName() + "."+ joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		logger.info("exec: {}, {}, {}, {}",session.getAttribute("user"), methodName, Arrays.toString(args),result);
	}
	
}
