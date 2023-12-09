package com.aweit.dynproxy;

import java.lang.reflect.Method;
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.stereotype.Component;

@Component
public class HijackAfterMethod implements AfterReturningAdvice {
	
	@Override
	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("%s方法執行後,回傳值:%s%n", method.getName(), returnValue);
	}
	
}
