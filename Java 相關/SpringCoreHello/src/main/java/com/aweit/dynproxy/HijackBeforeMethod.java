package com.aweit.dynproxy;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.stereotype.Component;

@Component
public class HijackBeforeMethod implements MethodBeforeAdvice {

	@Override
	public void before(Method method, Object[] args, Object target) throws Throwable {
		System.out.printf("%s方法執行前,參數:%s%n",method.getName(),Arrays.toString(args));
	}
}
