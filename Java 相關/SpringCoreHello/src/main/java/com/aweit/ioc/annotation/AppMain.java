package com.aweit.ioc.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *  --add-opens java.base/java.lang=ALL-UNNAMED
 */
public class AppMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(123);

	}

}
