package com.aweit.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

// Define a custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Before {
    String value() default "Default Value";
}

public class AnnotationDemo {

	@Before(value = "Custom Value")
    public void myAnnotatedMethod() {
		
    }
	
	public static void main(String[] args) throws ClassNotFoundException {

		 AnnotationDemo demo = new AnnotationDemo();
	     demo.processAnnotations();
	}
	
	private void processAnnotations() throws ClassNotFoundException {

        Class<?> clazz = Class.forName("com.aweit.test.AnnotationDemo");

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Before.class)) {

            	Before annotation = method.getAnnotation(Before.class);

                System.out.println("Method: " + method.getName() + ", Annotation Value: " + annotation.value());
            }
        }
    }
}
